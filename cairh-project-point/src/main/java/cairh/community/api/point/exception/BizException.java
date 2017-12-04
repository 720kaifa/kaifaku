package cairh.community.api.point.exception;

/**
 * Created by duanxq on 2016/11/21.
 */
public class BizException extends RuntimeException{

    public BizException() {
    }

    public BizException(String error_info) {
        setError_no("-1");
        setError_info(error_info);
    }

    public BizException(String error_no, String error_info) {
        setError_no(error_no);
        setError_info(error_info);
    }

    private String error_no;

    private String error_info;

    public String getError_no() {
        return error_no;
    }

    public void setError_no(String error_no) {
        this.error_no = error_no;
    }

    public String getError_info() {
        return error_info;
    }

    public void setError_info(String error_info) {
        this.error_info = error_info;
    }
}
