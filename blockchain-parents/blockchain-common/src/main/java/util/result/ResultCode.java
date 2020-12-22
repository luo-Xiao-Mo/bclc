package util.result;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200),//成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证（签名错误）
    LOGIN_FAIL(402),//登陆失败
    FORBIDDEN(403),//拒绝请求（登陆用户权限不足）｜无访问权限
    NOT_FOUND(404),//接口不存在 ｜请求资源不存在
    INTERNAL_SERVER_ERROR(500),//服务器内部错误 ｜ 处理失败
    SPECIAL_ERROR(501);

    private int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
