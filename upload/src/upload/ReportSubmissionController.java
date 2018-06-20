package upload;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ReportSubmissionController {
	
	@RequestMapping(value = "/submission.do", method=RequestMethod.GET)
	public String form() {
		return "submissionForm";
	}
	
	@RequestMapping(value = "/submitReport1.do", method = RequestMethod.POST)
	public String submitReport1(
			@RequestParam("studentNumber") String studentNumber,
			@RequestParam("report") MultipartFile report) {
		printInfo(studentNumber, report);
		String fileName = report.getOriginalFilename();
		String path = "C:\\upload\\" + fileName;
		File f = new File(path);
		try {
			report.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "submissionComplete";
	}
	
	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일: " + report.getOriginalFilename());
	}
	
	
	@RequestMapping(value = "/submitReport2.do", method = RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request) {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		printInfo(studentNumber, report);
		String fileName = report.getOriginalFilename();
		String path = "C:\\upload\\" + fileName;
		File f = new File(path);
		try {
			report.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "submissionComplete";
	}
	
	@RequestMapping(value = "/submitReport3.do", method = RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand) {
		printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
		MultipartFile report = reportCommand.getReport();
		String fileName = report.getOriginalFilename();
		String path = "C:\\upload\\" + fileName;
		File f = new File(path);
		try {
			report.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "submissionComplete";
	}
}
