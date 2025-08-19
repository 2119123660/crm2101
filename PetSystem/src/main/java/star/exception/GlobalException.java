package star.exception;


import star.result.ResultCodeEnum;

public class GlobalException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 通过状态码和错误消息创建异常对象
     * @param message
     * @param code
     */
    public GlobalException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public GlobalException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }


    @Override
    public String toString() {
        return "GlobalException{" +
                "code=" + code +
                '}';
    }
}