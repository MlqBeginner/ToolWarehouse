package uitl;

import java.util.List;

public class PageUtil<E> {

    private  int currPageNo = 1;// 当前页码
    private  int pageSie = 2;// 页面大小，每页显示的数量
    private  int totalCount;// 记录总数
    private  int totalPageCount;// 总页数
    private  List<E> userList;//用户列表

    public List<E> getUserList() {
        return userList;
    }

    public void setUserList(List<E> userList) {
        this.userList = userList;
    }

    public  int getCurrPageNo() {
        return currPageNo;
    }

    public  void setCurrPageNo(int currPageNo) {
      this.currPageNo = (currPageNo>totalPageCount)?totalPageCount:currPageNo;
    }

    public  int getPageSie() {
        return pageSie;
    }

    public  void setPageSie(int pageSie) {
        this.pageSie = (pageSie==0)?2:pageSie;
    }

    public  int getTotalCount() {
        return totalCount;
    }

    public  void setTotalCount(int totalCount) {
        if (totalCount > 0) {
            this.totalCount = totalCount;
            totalPageCount=(totalCount%pageSie==0)?totalCount/pageSie:totalCount/pageSie+1;
        }
    }

    public  int getTotalPageCount() {
        return totalPageCount;
    }

    public  void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }
}
