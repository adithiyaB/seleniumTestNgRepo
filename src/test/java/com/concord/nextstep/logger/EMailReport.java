//package com.concord.nextstep.logger;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.StringWriter;
//import java.util.Properties;
//
//import javax.activation.DataHandler;
//import javax.activation.DataSource;
//import javax.activation.FileDataSource;
//import javax.mail.Authenticator;
//import javax.mail.BodyPart;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//
//import org.apache.velocity.Template;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.VelocityEngine;
//
//import com.concord.nextstep.framework.GlobalVariable;
//import com.concord.nextstep.helper.DateTimeHelper;
//
//public class EMailReport {
//	public static void sendEmail() throws IOException {
//		System.out.println("Sending Email.....");
//		String host = "outlook.office365.com";
//		final String user = "AzureUser@Concord.net";
//		final String password = "nHsT#G@ow8vkG";					
//		String to = buildToList(GlobalVariable.prop.getProperty("EMailList"));
//		Properties props = new Properties();
//		props.put("mail.smtp.host", host);
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.port", 587);
//		Session session = Session.getDefaultInstance(props, new Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(user, password);
//			}
//		});
//
//		try {
//			MimeMessage message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(user));
//			// message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//			InternetAddress[] parse = InternetAddress.parse(to, true);
//			message.setRecipients(javax.mail.Message.RecipientType.TO, parse);
//
//			message.setSubject("NEXTSTEP - Automation Report");
//			MimeMultipart multipart = new MimeMultipart("related");
//
//			BodyPart messageBodyPart = new MimeBodyPart();
//
//			File f = new File("./AutomationLog/Chart/source.html");
//			BufferedWriter bw = new BufferedWriter(new FileWriter(f));			
//			bw.write("<html> <head>    <title>Concord Automation Test</title>    <meta charset=\"utf-8\">\r\n" + 
//					"									    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
//					"									    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n" + 
//					"									    <style type=\"text/css\">        body,        table,        td,\r\n" + 
//					"									a {            -webkit-text-size-adjust: 100%;\r\n" + 
//					"									            -ms-text-size-adjust: 100%;        }\r\n" + 
//					"									        /* Prevent WebKit and Windows mobile changing default text sizes */        \r\n" + 
//					"									        table,        td {            mso-table-lspace: 0pt;\r\n" + 
//					"									            mso-table-rspace: 0pt;        }\r\n" + 
//					"									        /* Remove spacing between tables in Outlook 2007 and up */        \r\n" + 
//					"									        img {            -ms-interpolation-mode: bicubic;        }\r\n" + 
//					"									        /* Allow smoother rendering of resized image in Internet Explorer */        \r\n" + 
//					"									        img {            border: 0;        height: auto;\r\n" + 
//					"									            line-height: 100%;            outline: none;\r\n" + 
//					"									            text-decoration: none;        }                table {\r\n" + 
//					"									            border-collapse: collapse !important;        }        \r\n" + 
//					"									        body {            height: 100% !important;\r\n" + 
//					"									            margin: 0 !important;            padding: 0 !important;\r\n" + 
//					"									            width: 100% !important;        }        \r\n" + 
//					"									        a[x-apple-data-detectors] {            color: inherit !important;\r\n" + 
//					"									            text-decoration: none !important;            font-size: inherit !important;\r\n" + 
//					"									            font-family: inherit !important;\r\n" + 
//					"									            font-weight: inherit !important;\r\n" + 
//					"									            line-height: inherit !important;        }        \r\n" + 
//					"									        ul li {            padding: 0px 0px 8px 0px;        }        \r\n" + 
//					"									        .Coverage table tr td {            text-align: center;        }\r\n" + 
//					"									        /* MOBILE STYLES */        \r\n" + 
//					"									        @media screen and (max-width: 525px) {            .responsive-table {\r\n" + 
//					"									                width: 100% !important;            }\r\n" + 
//					"									            .padding-copy {                padding: 10px 5% 10px 5% !important;\r\n" + 
//					"									                text-align: center;            }\r\n" + 
//					"									            .padding-05responsive {                padding: 50px 0px 0px 0px!important;\r\n" + 
//					"									                text-align: center!important;            }\r\n" + 
//					"									            .padding-statusresponsive {\r\n" + 
//					"									                padding: 10px 0px 0px 0px!important;\r\n" + 
//					"									                text-align: center!important;            }        }\r\n" + 
//					"									                div[style*=\"margin: 16px 0;\"] {\r\n" + 
//					"									            margin: 0 !important;        }    </style>\r\n" + 
//					"												</head>\r\n" + 
//					"									<body style=\"margin: 0 !important; padding: 0 !important;\">\r\n" + 
//					"									\r\n" + 
//					"									    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">        <tr>\r\n" + 
//					"									            <td align=\"center\" style=\"padding: 30px 0px;background-color:#F2F2F2;\">\r\n" + 
//					"									                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 560px;\" class=\"responsive-table\">\r\n" + 
//					"									                    <tr>                        <td>\r\n" + 
//					"									                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
//					"									                                <tr>\r\n" + 
//					"									                                    <td><img src=\"cid:logo\" align=\"center\" height=\"150\" width=\"500\" ></td>\r\n" + 
//					"									                            </table>                        </td>\r\n" + 
//					"									                    </tr>                </table>             </td>\r\n" + 
//					"									        </tr>        <tr>\r\n" + 
//					"									            <td bgcolor=\"#F2F2F2\" align=\"center\" style=\"padding: 0px 0px 0px 0px\" class=\"padding\">\r\n" + 
//					"									                <table bgcolor=\"#273542\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 560px;width:560px;\" class=\"responsive-table\">\r\n" + 
//					"									                    <tr>\r\n" + 
//					"									                        <td style=\"padding: 5px 10px 10px 10px;\">\r\n" + 
//					"									                            <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\r\n" + 
//					"									                                <tr>\r\n" + 
//					"									                                    <td valign=\"top\" class=\"mobile-wrapper\">\r\n" + 
//					"									                                        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" align=\"left\">\r\n" + 
//					"									                                            <tr>\r\n" + 
//					"									                                                <td align=\"left\" style=\"font-family: Trebuchet MS, sans-serif; color: #fff; font-size: 13px;padding:10px 0px 0px 0px;\">Project</td>\r\n" + 
//					"									                                                <td align=\"left\" style=\"font-family: Trebuchet MS, sans-serif; color: #fff; font-size: 13px;padding:10px 0px 0px 0px;\">: <b>NEXTSTEP Automation</b></td>\r\n" + 
//					"									                                            </tr>\r\n" + 
//					"									                                            <tr>\r\n" + 
//					"									                                                <td align=\"left\" style=\"font-family: Trebuchet MS, sans-serif; color: #fff; font-size: 13px;padding:10px 0px 0px 0px;\">Test Type</td>\r\n" + 
//					"									                                                <td align=\"left\" style=\"font-family: Trebuchet MS, sans-serif; color: #fff; font-size: 13px;padding:10px 0px 0px 0px;\">: "+GlobalVariable.testType+"</td>\r\n" + 
//					"									                                            </tr>\r\n" + 
//					"									                                            <tr>\r\n" + 
//					"									                                                <td align=\"left\" style=\"font-family: Trebuchet MS, sans-serif; color: #fff; font-size: 14px;padding:10px 0px 0px 0px;\">Env</td>\r\n" + 
//					"									                                                <td align=\"left\" style=\"font-family: Trebuchet MS, sans-serif; color: #fff; font-size: 14px;padding:10px 0px 0px 0px;\">: "+GlobalVariable.env+"  </td>\r\n" + 
//					"									                                            </tr>\r\n" + 
//					"									                                            <tr>\r\n" + 
//					"									                                                <td align=\"left\" style=\"font-family: Trebuchet MS, sans-serif; color: #fff; font-size: 14px;padding:10px 0px 0px 0px;\">Date</td>\r\n" + 
//					"									                                                <td align=\"left\" style=\"font-family: Trebuchet MS, sans-serif; color: #fff; font-size: 14px;padding:10px 0px 0px 0px;\">: "+DateTimeHelper.GetCurrentTimeAsString()+"  </td>\r\n" + 
//					"									                                            </tr>\r\n" + 
//					"									                                        </table>\r\n" + 
//					"									                                    </td>                                </tr>\r\n" + 
//					"									                            </table>                        </td>\r\n" + 
//					"									                    </tr>                </table>            </td>\r\n" + 
//					"									     	   </tr>  						   \r\n" + 
//					"											    						   <tr>\r\n" + 
//					"										            <td bgcolor=\"#F2F2F2\" align=\"center\" style=\"padding: 16px 0px 0px 0px\" class=\"padding\">\r\n" + 
//					"										                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 560px;width:560px;\" class=\"responsive-table\">\r\n" + 
//					"										                    <tr>                        <td style=\"padding: 5px 10px 10px 20px;\">\r\n" + 
//					"										                            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"175\"align=\"left\">\r\n" + 
//					"										                                <td valign=\"top\" class=\"mobile-wrapper\">\r\n" + 
//					"										                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" align=\"left\"> \r\n" + 
//					"										                                        <tr>\r\n" + 
//					"										                                            <td align=\"left\" style=\"font-family: Trebuchet MS, sans-serif; color: 1E0C0B; font-size: 12px;padding:10px 0px 0px 0px;\">Total Tests</td>\r\n" + 
//					"										                                            <td align=\"left\" style=\"font-family: Trebuchet MS, sans-serif; color: 1E0C0B; font-size: 12px;padding:10px 0px 0px 0px;\">: "+Chart.totalTC+" </td> \r\n" + 
//					"										                                        </tr>\r\n" + 
//					"										                                        <tr>\r\n" + 
//					"										                                            <td align=\"left\" style=\"font-family: Trebuchet MS, sans-serif; color: 1E0C0B; font-size: 12px;padding:10px 0px 0px 0px;\">Tests Pass %</td>\r\n" + 
//					"										                                            <td align=\"left\" style=\"font-family: Trebuchet MS, sans-serif; color: 1E0C0B; font-size: 12px;padding:10px 0px 0px 0px;\">: "+Chart.passPer+" %</td>\r\n" + 
//					"										                                        </tr>\r\n" + 
//					"										                                        <tr>\r\n" + 
//					"										                                            <td align=\"left\" style=\"font-family: Trebuchet MS, sans-serif; color: 1E0C0B; font-size: 12px;padding:10px 0px 0px 0px;\">Tests Fail %</td>\r\n" + 
//					"										                                            <td align=\"left\" style=\"font-family: Trebuchet MS, sans-serif; color: 1E0C0B; font-size: 12px;padding:10px 0px 0px 0px;\">: "+Chart.failPer+" %</td>\r\n" + 
//					"										                                        </tr>					                                        \r\n" + 
//					"										                                    </table>                                </td>\r\n" + 
//					"										                            </table>                        </td>\r\n" + 
//					"										                    </tr> 	 					\r\n" + 
//					"										                    <tr>\r\n" + 
//					"										                        <td bgcolor=\"#F2F2F2\" align=\"center\" style=\"padding: 20px 0px;\">\r\n" + 
//					"										                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"560\" class=\"responsive-table Coverage\">\r\n" + 
//					"										                                <tr>                                    <td>\r\n" + 
//					"										                                        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"560\">\r\n" + 
//					"										                                            <tr>\r\n" + 
//					"										                                                <td style=\"padding: 25px 0px 0px 0px\"><img src=\"cid:piechart\" align=\"center\" height=\"400\" width=\"560\"></td>\r\n" + 
//					"										                                            </tr>\r\n" + 
//					"										                                        </table>\r\n" + 
//					"										                                    </td>                                \r\n" + 
//					"																			</tr>\r\n" + 
//					"										                            </table>                        </td>\r\n" + 
//					"										                    </tr> 										\r\n" + 
//					"															 										<tr>\r\n" + 
//					"									                        <td bgcolor=\"#F2F2F2\" align=\"center\" style=\"padding: 20px 0px;\">\r\n" + 
//					"									                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"max-width: 500px;\" class=\"responsive-table\">\r\n" + 
//					"									                                <tr>\r\n" + 
//					"									                                    <td align=\"center\" style=\"font-size: 12px; line-height: 18px; font-family: Trebuchet MS, sans-serif; color:#BDBDBD;\">\r\n" + 
//					"									                                        This email was sent to you because you indicated that you want to receive news regarding automation testing for the project <b>NEXTSTEP</b><br>\r\n" + 
//					"									                                        \r\n" + 
//					"									                                        <span style=\"font-family: Trebuchet MS, sans-serif; font-size: 12px; color: #BDBDBD;\">This message, and any attachments, contain(s) information that may be confidential or protected by privilege from disclosure and is intended only for the individual or entity named above. No one else may disclose, copy, distribute or use the contents of this message for any purpose. Its unauthorized use, dissemination or duplication is strictly prohibited and may be unlawful. If you receive this message in error or you otherwise are not an authorized recipient, please immediately delete the message and any attachments and notify the sender.</span>\r\n" + 
//					"									                                    </td>                                 </tr>\r\n" + 
//					"									                            </table>\r\n" + 
//					"									                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"max-width: 500px;\" class=\"responsive-table\">\r\n" + 
//					"									                                <tr>\r\n" + 
//					"									                                    <td align=\"center\" style=\"font-size: 12px; line-height: 18px; font-family: Trebuchet MS, sans-serif; color:#BDBDBD;padding-top:15px;\">\r\n" + 
//					"									                                        Concord Technologies &#169; 2021\r\n" + 
//					"									                                    </td>                                 </tr>\r\n" + 
//					"									                            </table>                         </td>\r\n" + 
//					"									                    </tr>                 </table>             </td>\r\n" + 
//					"									        </tr>     </table> </body> 						</html>");
//			
//			bw.close();
//
//			VelocityEngine ve = new VelocityEngine();
//			ve.init();
//			Template t = ve.getTemplate("./AutomationLog/Chart/source.html");
//			StringWriter writer = new StringWriter();
//			VelocityContext context = new VelocityContext();
//
//			t.merge(context, writer);
//
//			String htmlText = writer.toString();
//			messageBodyPart.setContent(htmlText, "text/html");
//			multipart.addBodyPart(messageBodyPart);
//
//			messageBodyPart = new MimeBodyPart();
//			DataSource logo = new FileDataSource("./img/Concord Mail.png");
//			messageBodyPart.setDataHandler(new DataHandler(logo));
//			messageBodyPart.addHeader("Content-ID", "<logo>");
//			multipart.addBodyPart(messageBodyPart);
//
//			messageBodyPart = new MimeBodyPart();
//			DataSource bar = new FileDataSource("./AutomationLog/Chart/PieChart.jpeg");//
//			messageBodyPart.setDataHandler(new DataHandler(bar));
//			messageBodyPart.addHeader("Content-ID", "<piechart>");
//			multipart.addBodyPart(messageBodyPart);
//			
//			if(GlobalVariable.prop.getProperty("executionType").equals("Metrics"))
//			{
//				MimeBodyPart attachMetrics = new MimeBodyPart();
//				message.setContent(multipart);
//				attachMetrics.attachFile(Logger.metricsHTMLPath);
//				multipart.addBodyPart(attachMetrics);
//			}
//			
//			MimeBodyPart attachPart = new MimeBodyPart();
//			message.setContent(multipart);
//			attachPart.attachFile(Logger.filePath);
//			multipart.addBodyPart(attachPart);
//
//			MimeBodyPart attachPartHTML = new MimeBodyPart();
//			attachPartHTML.attachFile(Logger.filePathHTML);
//			multipart.addBodyPart(attachPartHTML);
//			Transport.send(message);
//			System.out.println("message sent successfully...");
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//	}
//	private enum emailGroup 
//	{
//		QA, QATeam, Dev, Internal
//	}
//	
//	public static String buildToList(String group)
//	{
//		emailGroup toList = emailGroup.valueOf(group);
//		String recipient;
//		try
//		{
//			switch(toList)
//			{
//				case QA:
//					recipient = "santhakumar.c@concord.net, gopikrishnan.v@concord.net";
//					break;
//				case QATeam:
//					recipient = "sathyanarayanagupta.k@concord.net, indhirakumar.p@concord.net, gopikrishnan.v@concord.net, santhakumar.c@concord.net";
//					break;
//				case Dev:
//					recipient = "saravanan.s@concord.net, sathyanarayanagupta.k@concord.net, sureshkumar.n@concord.net, indhirakumar.p@concord.net, gopikrishnan.v@concord.net, santhakumar.c@concord.net";
//					break;
//				case Internal:
//					recipient = "saravanan.s@concord.net, sathyanarayanagupta.k@concord.net, sureshkumar.n@concord.net, indhirakumar.p@concord.net, gopikrishnan.v@concord.net, santhakumar.c@concord.net";
//					break;
//				default:
//					recipient = "gopikrishnan.v@concord.net";
//					break;
//			}
//		}
//		catch(Exception e)
//		{
//			recipient = "gopikrishnan.v@concord.net";
//		}						
//		return recipient;
//	}
//}
