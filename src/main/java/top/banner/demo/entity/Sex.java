package top.banner.demo.entity;


/**
 * @author: XGL
 */
public enum Sex {


    /**
     * 未知
     */
    UNKNOWN("未知"),

    /**
     * 男
     */
    MAN("男"),

    /**
     * 女
     */
    FEMALE("女");


    private String message;

    private Sex(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
