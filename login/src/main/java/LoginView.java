public class LoginView {
    /**
     * 返回页面内容
     * @param model
     * @return
     */
    public String render(LoginModel model){
        //请完善代码，返回页面内容。
        String msg = model.getMsg();
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>" + msg + "</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>" + msg + "</p>\n" +
                "</body>\n" +
                "</html>";
    }
}
