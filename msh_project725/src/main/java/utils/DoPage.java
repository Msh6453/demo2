package utils;

/**
 * Created by Administrator on 2018/6/23.
 */
public class DoPage {
    private  static final int PAGESIZE=5;
    public static int getTotalPages(int totalRows){
        return totalRows%PAGESIZE==0?totalRows/PAGESIZE : totalRows/PAGESIZE +1;
    }
}