import constants.C;
import entity.DynamicArr;
import entity.Result;
import utils.Calculator;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;
import java.util.UUID;

@WebServlet(C.UPLOAD)
@MultipartConfig(fileSizeThreshold = 1024 *  1024)
public class UploadController extends HttpServlet {

    final Calculator calculator = new Calculator();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Part file = req.getPart("file");
        readData(file.getInputStream(), req, resp);

//        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }

    private void dataOutput(InputStream inputStream) throws IOException {
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
    }

    private void readData(InputStream inputStream, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        final Timestamp begin = Timestamp.valueOf(LocalDateTime.now());
        req.setAttribute("begin", begin);

        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        DynamicArr arr = new DynamicArr();
        int rowsCount = 0;
        int validRows = 0;
        LinkedList<String> wrongs = new LinkedList<>();

        while ((line = bufferedReader.readLine()) != null){
            rowsCount++;
            try {
                int i = Integer.parseInt(line);
                validRows++;
                arr.add(i);
            } catch (NumberFormatException e){
                wrongs.add(line);
                System.out.println(e.getMessage());
            }
        }
        final Result result = calculator.calc(arr);
        req.setAttribute("valid", validRows);
        req.setAttribute("rows", rowsCount);
        req.setAttribute("wrongs", wrongs);
        req.setAttribute("result", result);


        final Timestamp end = Timestamp.valueOf(LocalDateTime.now());
        req.setAttribute("end", end);
        req.setAttribute("length", 1f * (end.getTime() - begin.getTime()) / 1000);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
