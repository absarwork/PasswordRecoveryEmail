package com.mm.api.emailer;

import com.mm.api.bean.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 * @author adeel
 */

@Service
public class EmailMessagesFactory {

    public static ResponseDTO sendPasswordRecoveryEmail(EmailMessage messgae, String token) {
        try {
            messgae.setHtmlTemplate(getEmailTemplate(messgae.getLogoUrl(), messgae.getRedirectUrl(), messgae.getSenderFirstName() + " " + messgae.getSenderLastName()));
            Emailer emailer = new Emailer();
            return emailer.sendEmail(messgae);
        } catch (Exception ex) {
            return new ResponseDTO(500, null, null, false, ex.getMessage());
        }
    }
    private static String getEmailTemplate(String imageUrl, String redirectUrl, String user) {
        String htmlTemp = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\" lang=\"en\"><head>\n" +
                "    <title>Reset your Mentoring Minds password</title>\n" +
                "    <meta property=\"og:title\" content=\"Reset your Mentoring Minds password\">\n" +
                "    <meta name=\"twitter:title\" content=\"Reset your Mentoring Minds password\">\n" +
                "    \n" +
                "    \n" +
                "    \n" +
                "<meta name=\"x-apple-disable-message-reformatting\">\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "\n" +
                "\n" +
                "    <!--[if gte mso 9]>\n" +
                "  <xml>\n" +
                "      <o:OfficeDocumentSettings>\n" +
                "      <o:AllowPNG/>\n" +
                "      <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                "      </o:OfficeDocumentSettings>\n" +
                "  </xml>\n" +
                "  \n" +
                "  <style>\n" +
                "    ul > li {\n" +
                "      text-indent: -1em;\n" +
                "    }\n" +
                "  </style>\n" +
                "<![endif]-->\n" +
                "<!--[if mso]>\n" +
                "<style type=\"text/css\">\nReset My Password" +
                " body, td {font-family: Arial, Helvetica, sans-serif;}\n" +
                "</style>\n" +
                "<![endif]-->\n" +
                "\n" +
                "\n" +
                "    \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "      \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "    \n" +
                "\n" +
                "\n" +
                "  <meta name=\"generator\" content=\"HubSpot\"><meta property=\"og:url\" content=\"http://email.mentoringminds.com/reset-your-mentoring-minds-password?hs_preview=XyVIhOqe-44794641509\"><meta name=\"robots\" content=\"noindex,follow\"><!--[if !((mso)|(IE))]><!-- --><style type=\"text/css\">@media only screen and (max-width:639px){img.stretch-on-mobile,.hs_rss_email_entries_table img{height:auto !important;width:100% !important}\n" +
                ".display_block_on_small_screens{display:block}.hs_padded{padding-left:20px !important;padding-right:20px !important}\n" +
                "}</style><!--<![endif]--><style type=\"text/css\">body[data-outlook-cycle] img.stretch-on-mobile,body[data-outlook-cycle] .hs_rss_email_entries_table img{height:auto !important;width:100% !important}\n" +
                "body[data-outlook-cycle] .hs_padded{padding-left:20px !important;padding-right:20px !important}\n" +
                "a[x-apple-data-detectors]{color:inherit !important;text-decoration:none !important;font-size:inherit !important;font-family:inherit !important;font-weight:inherit !important;line-height:inherit !important}\n" +
                "#outlook a{padding:0}.yshortcuts a{border-bottom:none !important}a{text-decoration:underline}\n" +
                ".ExternalClass{width:100%}.ExternalClass,.ExternalClass p,.ExternalClass td,.ExternalClass div,.ExternalClass span,.ExternalClass font{line-height:100%}\n" +
                "p{margin:0}body{-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%;-webkit-font-smoothing:antialiased;moz-osx-font-smoothing:grayscale}</style></head>\n" +
                "  <body bgcolor=\"#ffffff\" style=\"margin:0 !important; padding:0 !important; font-family:Helvetica, Arial, sans-serif; font-size:15px; color:#444444; word-break:break-word\">\n" +
                "    \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "    \n" +
                "<!--[if gte mso 9]>\n" +
                "<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
                "  \n" +
                "    <v:fill type=\"tile\" size=\"100%,100%\" color=\"#ffffff\"/>\n" +
                "  \n" +
                "</v:background>\n" +
                "<![endif]-->\n" +
                "\n" +
                "\n" +
                "    <div class=\"hse-body-background\" style=\"background-color:#ffffff\" bgcolor=\"#ffffff\">\n" +
                "      <table role=\"presentation\" class=\"hse-body-wrapper-table hse-full-width-template\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0 !important; border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt; margin:0; padding:0; width:100% !important; min-width:320px !important; height:100% !important\" width=\"100%\" height=\"100%\">\n" +
                "        <tbody><tr>\n" +
                "          <td class=\"hse-body-wrapper-td\" valign=\"top\" style=\"border-collapse:collapse; mso-line-height-rule:exactly; font-family:Helvetica, Arial, sans-serif; font-size:15px; color:#444444; word-break:break-word; padding-top:0px\">\n" +
                "            <div id=\"hs_cos_wrapper_main\" class=\"hs_cos_wrapper hs_cos_wrapper_widget hs_cos_wrapper_type_email_flex_area\" style=\"color: inherit; font-size: inherit; line-height: inherit;\" data-hs-cos-general-type=\"widget\" data-hs-cos-type=\"email_flex_area\">  <div id=\"builtin_section-0\" class=\"hse-section hse-section-full-width\" style=\"padding-left:0px; padding-right:0px; background-color:#ffffff\" bgcolor=\"#ffffff\">\n" +
                "\n" +
                "    \n" +
                "      \n" +
                "      <!--[if gte mso 9]><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"\n" +
                "        width=\"100%\" style=\"width:100%\" bgcolor=\"#ffffff\"\n" +
                "        style=\"border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;\"\n" +
                "      ><tbody><tr><td valign=\"top\"><![endif]-->\n" +
                "    \n" +
                "    \n" +
                "    <!--[if !((mso)|(IE))]><!-- -->\n" +
                "      <div class=\"hse-column-container\" style=\"min-width:280px; width:100%; border-collapse:collapse; border-spacing:0; max-width:100%; Margin-left:0; Margin-right:0\">\n" +
                "    <!--<![endif]-->\n" +
                "    \n" +
                "    <!--[if (mso)|(IE)]>\n" +
                "      <div class=\"hse-column-container\" style=\"min-width:280px;width:100%;border-collapse:collapse;border-spacing:0;\">\n" +
                "      <table align=\"center\" style=\"border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\n" +
                "      <tr>\n" +
                "    <![endif]-->\n" +
                "\n" +
                "    <!--[if (mso)|(IE)]>\n" +
                "  <td valign=\"top\" style=\"width:100%;\">\n" +
                "<![endif]-->\n" +
                "<!--[if gte mso 9]>\n" +
                "  <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt;width:100%\">\n" +
                "<![endif]-->\n" +
                "<div id=\"builtin_column_0-0\" class=\"hse-column\">\n" +
                "  <div id=\"hs_cos_wrapper_module_16179966188419\" class=\"hs_cos_wrapper hs_cos_wrapper_widget hs_cos_wrapper_type_module\" style=\"color: inherit; font-size: inherit; line-height: inherit;\" data-hs-cos-general-type=\"widget\" data-hs-cos-type=\"module\">\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div style=\"overflow:hidden\">\n" +
                "<table role=\"presentation\" class=\"hse-pre-header hse-secondary\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0 !important; border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt; text-align:right; font-family:Arial, sans-serif; font-size:12px; line-height:135%; color:#23496d; margin-bottom:0; padding:0\" align=\"right\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td align=\"right\" valign=\"top\" style=\"border-collapse:collapse; mso-line-height-rule:exactly; color:#444444; word-break:break-word; text-align:right; font-family:Arial, sans-serif; font-size:12px; padding:10px 0; margin-bottom:0; line-height:135%\">\n" +
                "                <a href=\"http://email.mentoringminds.com/reset-your-mentoring-minds-password?hs_preview=XyVIhOqe-44794641509&amp;utm_campaign=Marketing%20Operations&amp;utm_source=hs_email&amp;utm_medium=email&amp;utm_content=2&amp;_hsenc=p2ANqtz-9CLw6b-kFLxf-bwhWZW0kalP1sN3JjHmLFOcvk8hBa8WzkY7VDYTQsY9OyBqkoHMADVetEgV8c46RavltA50fddiQL5Q\" style=\"mso-line-height-rule:exactly; color:#a3238e; font-weight:normal; text-decoration:none; font-style:normal\" data-hs-link-id=\"0\" target=\"_blank\"></a>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "</div>\n" +
                "<table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-spacing:0 !important; border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt\"><tbody><tr><td class=\"hs_padded\" style=\"border-collapse:collapse; mso-line-height-rule:exactly; font-family:Helvetica, Arial, sans-serif; font-size:15px; color:#444444; word-break:break-word; padding:10px\"><div id=\"hs_cos_wrapper_primary_rich_text_module\" class=\"hs_cos_wrapper hs_cos_wrapper_widget hs_cos_wrapper_type_module\" style=\"color: inherit; font-size: inherit; line-height: inherit;\" data-hs-cos-general-type=\"widget\" data-hs-cos-type=\"module\"><div id=\"hs_cos_wrapper_primary_rich_text_module_\" class=\"hs_cos_wrapper hs_cos_wrapper_widget hs_cos_wrapper_type_rich_text\" style=\"color: inherit; font-size: inherit; line-height: inherit;\" data-hs-cos-general-type=\"widget\" data-hs-cos-type=\"rich_text\"><p style=\"mso-line-height-rule:exactly; line-height:175%; margin-bottom:10px\">Hi "+user+",</p>\n" +
                "<p style=\"mso-line-height-rule:exactly; line-height:175%; margin-bottom:10px\">We received a request to change your password. You can reset your password by clicking the link below.</p>\n" +
                "<p style=\"mso-line-height-rule:exactly; line-height:175%; margin-bottom:10px\"><a href=\""+redirectUrl+"\" style=\"mso-line-height-rule:exactly; text-decoration:none; color:#a3238e; font-weight:bold\" rel=\"noopener\" data-hs-link-id=\"0\" target=\"_blank\">Reset My Password</a></p>\n" +
                "<p style=\"mso-line-height-rule:exactly; line-height:175%; margin-bottom:10px\">Didn't request this? Reply to this email and our team will make sure your account is secure.</p>\n" +
                "<p style=\"mso-line-height-rule:exactly; line-height:175%; margin-bottom:10px\">--</p>\n" +
                "<p style=\"mso-line-height-rule:exactly; line-height:175%; margin-bottom:10px\">Mentoring Minds<br>[p] <a href=\"tel:8005855258\" style=\"mso-line-height-rule:exactly; text-decoration:none; color:#a3238e\" rel=\"noopener\" data-hs-link-id=\"0\" target=\"_blank\">800.585.5258</a><br>[e] <a href=\"mailto:info@mentoringminds.com\" style=\"mso-line-height-rule:exactly; text-decoration:none; color:#a3238e\" rel=\"noopener\" data-hs-link-id=\"0\" target=\"_blank\">info@mentoringminds.com</a></p></div></div></td></tr></tbody></table>\n" +
                "<div id=\"hs_cos_wrapper_module_16179947983031\" class=\"hs_cos_wrapper hs_cos_wrapper_widget hs_cos_wrapper_type_module\" style=\"color: inherit; font-size: inherit; line-height: inherit;\" data-hs-cos-general-type=\"widget\" data-hs-cos-type=\"module\">\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\n" +
                "\n" +
                "\n" +
                "<table class=\"hse-image-wrapper\" role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-spacing:0 !important; border-collapse:collapse; mso-table-lspace:0pt; mso-table-rspace:0pt\">\n" +
                "    <tbody>\n" +
                "        <tr>\n" +
                "            <td align=\"left\" valign=\"top\" style=\"border-collapse:collapse; mso-line-height-rule:exactly; font-family:Helvetica, Arial, sans-serif; color:#444444; word-break:break-word; text-align:left; padding:10px 20px; font-size:0px\">\n" +
                "                \n" +
                "                <img alt=\"mentoring-minds-logo\" src=\""+imageUrl+" style=\"outline:none; text-decoration:none; -ms-interpolation-mode:bicubic; max-width:100%; font-size:16px\" width=\"200\" align=\"middle\" srcset=\"https://email.mentoringminds.com/hs-fs/hubfs/Logos/mm-logo_800.png?upscale=true&amp;width=400&amp;upscale=true&amp;name=mm-logo_800.png 200w, https://email.mentoringminds.com/hs-fs/hubfs/Logos/mm-logo_800.png?upscale=true&amp;width=800&amp;upscale=true&amp;name=mm-logo_800.png 400w\" sizes=\"(max-width: 200px) 100vw, 200px\">\n" +
                "                \n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "</div>\n" +
                "</div>\n" +
                "<!--[if gte mso 9]></table><![endif]-->\n" +
                "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                "\n" +
                "\n" +
                "    <!--[if (mso)|(IE)]></tr></table><![endif]-->\n" +
                "\n" +
                "    </div>\n" +
                "   \n" +
                "      <!--[if gte mso 9]></td></tr></table><![endif]-->\n" +
                "   \n" +
                "  </div>\n" +
                "</div>\n" +
                "          </td>\n" +
                "        </tr>\n" +
                "      </tbody></table>\n" +
                "    </div>\n" +
                "  \n" +
                "</body></html>";
        return htmlTemp;
    }

    private static String getEmailTemplate_Old(String imageUrl, String redirectUrl, String user) {
        String htmlTemp = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                + "<head>"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                + "<title>Please Reset Your Password.</title>\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "\n"
                + "<div style=\"width:600.1px;margin:0 auto;\">\n"
                + "\t<div style=\"width:100%; " +
                "  background:#a3238e;" +
                "  background-image: -webkit-linear-gradient(#a3238e, #4e2b8a);\n" +
                "  background-image: -moz-linear-gradient(#a3238e, #4e2b8a);\n" +
                "  background-image: -o-linear-gradient(#a3238e, #4e2b8a);  \n" +
                "  background-image: linear-gradient(#a3238e, #4e2b8a);\n" +
                "  background: linear-gradient(#a3238e, #4e2b8a);height:70px;\">\n"
                + "    \t<h1 style=\"font-family:Arial, Helvetica, sans-serif;font-size:20px;font-weight:normal;color:#fff;text-align:center;padding:25px 0;\">Reset Password</h1>\n"
                + "    </div>\n"
                + "    <div style=\"border:1px solid #a3238e;padding:10px 7px;font-family:Arial, Helvetica, sans-serif;\">\n"
                + "    \t<h1 style=\"font-size:18px;color:#6d6e71;text-align:center;\"><img src=\"" + imageUrl + "\" width=50px height=50px></h1>\n"
                + "        <p style=\"font-size:13px;text-align:center;font-weight:bold; \">Dear "+user+",</p>\n"
                + "        <p style=\"font-size:13px;text-align:center;\">Please click the link below to reset your password.</p>\n"
                + "        <div style=\"color:#fff; background:#4e2b8a;width:300px;padding:6px;border-radius:10px;text-align:center;margin:0 auto;\">\n"
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


    public static ResponseDTO sendCmsNotification(ContentRefreshDTO contentRefreshDTO, String token) {
        try {
            EmailMessage messgae = new EmailMessage();
            messgae.setHtmlTemplate(getCmsEmailNotificationTemplate(contentRefreshDTO));
            messgae.setSandGridKey(contentRefreshDTO.getEmailApiKey());
            messgae.setRecipients(contentRefreshDTO.getToEmail());
            messgae.setFromEmail(contentRefreshDTO.getFromEmail());
            messgae.setSubject(contentRefreshDTO.getEmailSubject());
            Emailer emailer = new Emailer();
            return emailer.sendEmail(messgae);
        } catch (Exception ex) {
            return new ResponseDTO(500, null, null, false, ex.getMessage());
        }
    }

    public static String getCmsEmailNotificationTemplate(ContentRefreshDTO contentRefreshDTO) {
        String htmlTemp = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "\t<head>\n" +
                "\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "\t\t<title>Content Refresh Process.</title>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "\t\t<div style=\"width:600px;margin:0 auto;\">\n" +
                "\t\t\t<div style=\"width:100%;background:#a3238e;height:70px;\">\n" +
                "\t\t\t\t<h1 style=\"font-family:Arial, Helvetica, sans-serif;font-size:20px;font-weight:normal;color:#fff;text-align:center;padding:25px 0;\">Content Refresh Process</h1>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div style=\"border:1px solid #0056b3;padding:10px 7px;font-family:Arial, Helvetica, sans-serif;\">\n" +
                "<p style=\"font-size:13px;text-align:center;font-weight:bold;\">Dear Admin,</p>"+
                "\t\t\t\t<h1 style=\"font-size:18px;color:#6d6e71;text-align:center;\"></h1>\n" +
                "\t\t\t\t<p style=\"font-size:13px;text-align:center;\">Content Refresh Process Complate at\n"+new Date()+",\n For Book Ids "+contentRefreshDTO.getBookIds()+"</p>\n" +
                "\t\t\t\t<div style=\"color:#fff; background-color:#6770ff;width:300px;padding:6px;border-radius:6px;text-align:center;margin:0 auto;\">\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<p style=\"font-size:13px;text-align:center;\">The MentoringMinds Support Team.</p>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</body>\n" +
                "</html>\n" +
                "\t\t\t\t";
        return htmlTemp;
    }
}
