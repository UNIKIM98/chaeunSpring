package co.five.mprj;


import java.io.File;
import java.io.IOException;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.five.mprj.common.Command;

public class FileUpload implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		String saveDir = request.getServletContext().getRealPath("/attech/"); // 현재 프로젝트 디렉토리로
		int maxSize = 1024 * 1024 * 1024; // 최대 10M까지 업로드

		String fileName = "";
		String fileUrl = "";
		PrintWriter printWriter = null;
		JsonObject json = new JsonObject();

		try {
			MultipartRequest multi = new MultipartRequest( // 파일을 업로드시 request객체를 대체한다.
					request, saveDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
			
			File file = multi.getFile("upload");
//			System.out.println(multi.getFile("upload"));
			fileName = file.getName();

			printWriter = response.getWriter();
			response.setContentType("text/html");

			fileUrl = request.getContextPath() + "/attech/" + fileName;

			json.addProperty("uploaded", 1);
			json.addProperty("fileName", fileName);
			json.addProperty("url", fileUrl);
			printWriter.println(json);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}

		return null;
	}

}