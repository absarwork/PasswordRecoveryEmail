package com.mm.api.emailer;

import com.mm.api.bean.ResponseDTO;
import org.springframework.stereotype.Service;

/**
 *
 * @author adeel
 */

@Service
public class EmailMessagesFactory {

    public static ResponseDTO sendPasswordRecoveryEmail(EmailMessage messgae, String token) {
        try {
            messgae.setHtmlTemplate(getEmailTemplate(messgae.getLogoUrl(), messgae.getRedirectUrl(), messgae.getSenderFirstName()+" "+messgae.getSenderLastName()));
            Emailer emailer = new Emailer();
            return emailer.sendEmail(messgae);
        } catch (Exception ex) {
            return new ResponseDTO(500, null, null, false, ex.getMessage());
        }
    }

    private static String getEmailTemplate(String imageUrl, String redirectUrl, String user) {
        String htmlTemp = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                + "<head>"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                + "<title>Please Reset Your Password.</title>\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "\n"
                + "<div style=\width:500.1px;margin:0 auto;\">\n"
                + "\t<div style=\"width:100%;background:#a3238e;height:70px;\">\n"
                + "    \t<h1 style=\"font-family:Arial, Helvetica, sans-serif;font-size:20px;font-weight:normal;color:#fff;text-align:center;padding:25px 0;\">Reset Password</h1>\n"
                + "    </div>\n"
                + "    <div style=\"border:1px solid #a3238e;padding:10px 7px;font-family:Arial, Helvetica, sans-serif;\">\n"
                + "    \t<h1 style=\"font-size:18px;color:#6d6e71;text-align:center;\"><img src=\"" + imageUrl + "\" width=50px height=50px></h1>\n"
                + "        <p style=\"font-size:13px;text-align:center;font-weight:bold; \">Dear "+user+",</p>\n"
                + "        <p style=\"font-size:13px;text-align:center;\">Please click the link below to reset your password.</p>\n"
                + "        <div style=\"color:#fff; background-color:#a3238e;width:300px;padding:6px;border-radius:6px;text-align:center;margin:0 auto;\">\n"
                + "        \t<a href=\"" + redirectUrl + "\" target=\"_blank\" style=\"color:#ffffff; font-size:14px; font-weight:bold; padding:0 14px; display:inline-block; line-height:40px; text-align:center; text-decoration:none; -webkit-border-radius:3px; -moz-border-radius:3px; -ms-border-radius:3px; -o-border-radius:3px; border-radius:3px; \">Click Here to Reset Your Password!</a>\n"
                + "        </div>\n"
                + "        <p style=\"font-size:13px;text-align:center;\">The MentoringMinds Support Team.</p>\n"
                + "    </div>\n"
                + "</div>\n"
                + "</body>\n"
                + "</html>\n"
                + "\n";
        return htmlTemp;
    }
}
