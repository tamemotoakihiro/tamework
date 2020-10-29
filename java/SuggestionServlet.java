//多分サーブレットにしないと動かない。httprequestをもらわないと動かないから。
package tamework;

import java.io.*;
import java.util.*;
import javax.json.JsonObject;
//外部ファイルをimportしないと使えないっぽい。どのパスに入れたら使える？
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/suggestion")

public class SuggestionServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{

        try{

          /*
          // get the q parameter from URL
          $q = $_REQUEST["q"];

          $hint = "";

          // lookup all hints from array if $q is different from ""
          if ($q !== "") {
            $q = strtolower($q);
            $len=strlen($q);
            foreach($a as $name) {
              if (stristr($q, substr($name, 0, $len))) {
                if ($hint === "") {
                  $hint = $name;
                } else {
                  $hint .= ", $name";
                }
              }
            }
          }

          // Output "no suggestion" if no hint was found or output correct values
          echo $hint === "" ? "no suggestion" : $hint;
          */

          //パラメータ
          String keyword = request.getParameter(keyword);
          String datatype = "work_name";
          TameWebDao dao = new TameWebDao();
          List<TameWebDto> dtoL = dao.getTameDataList(datatype,keyword);
          String response1 = dtoL.get(1).getWork_name();
          String jsonStr = "{\"response\" : \"" +response1+ "\"}";
          JsonObject jsonObj = new JsonObject(jsonStr);
          //JSON化して返す方法：{}の形式を文字で記述して、responseをreturnする
          //List化すると、jsonに近くなる？
          PrintWriter out = response.getWriter();
          out.print(jsonObj);
          out.close();

        }catch(Exception e){
          e.printStackTrace();
        }

    }

}
