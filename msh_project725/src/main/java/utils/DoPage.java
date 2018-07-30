package utils;

/**
 * Created by Administrator on 2018/6/23.
 */
public class DoPage {
    private  static final int PAGESIZE=5;
    private  static final int PAGESIZE1=1;
    public static int getTotalPages(int totalRows){
        return totalRows%PAGESIZE==0?totalRows/PAGESIZE : totalRows/PAGESIZE +1;
    }
    public static int getTotalPages1(int totalRows){
        return totalRows%PAGESIZE1==0?totalRows/PAGESIZE1 : totalRows/PAGESIZE1 +1;
    }
}