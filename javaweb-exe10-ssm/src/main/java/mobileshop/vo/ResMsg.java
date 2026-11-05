package mobileshop.vo;

/** JSON response used by the Ajax registration endpoint. */
public class ResMsg {
    private String errcode;
    private String errmsg;
    private Object result;

    public String getErrcode() { return errcode; }
    public void setErrcode(String errcode) { this.errcode = errcode; }

    public String getErrmsg() { return errmsg; }
    public void setErrmsg(String errmsg) { this.errmsg = errmsg; }

    public Object getResult() { return result; }
    public void setResult(Object result) { this.result = result; }
}
