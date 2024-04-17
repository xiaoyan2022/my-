package com.dao;

import com.model.Culture;
import com.util.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CultureDao {

    private Connection conn;
    private PreparedStatement pstm;
    private Statement stm;
    private ResultSet rs;

    public boolean add(Culture culture) throws Exception {
        conn = DBUtils.getConnection();
        String sql="insert into culture(title,content,author,date)values(?,?,?,?)";
        pstm=conn.prepareStatement(sql);
        pstm.setString(1,culture.getTitle());
        pstm.setString(2,culture.getContent());
        pstm.setInt(3,culture.getAuthor());
        pstm.setDate(4,culture.getDate());
        return pstm.executeUpdate()>0;
    }

    public List<Culture> query() {
        List<Culture> cultures = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            String sql="select cno,title,content,author,date,likes,dislike,open,nickname from culture c,user u where c.author=u.uid";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()){
                int cno = rs.getInt("cno");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int author = rs.getInt("author");
                Date date = rs.getDate("date");
                int likes = rs.getInt("likes");
                int dislike = rs.getInt("dislike");
                int open = rs.getInt("open");
                String nickname = rs.getString("nickname");
                cultures.add(new Culture(cno,title,content,author,date,likes,dislike,nickname,open));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cultures;
    }

    public List<Culture> queryByCondition(String title,String content,String author) {
        List<Culture> cultures = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            String sql="select cno,title,content,author,date,likes,dislike,open,nickname from culture c,user u where c.author=u.uid and title like ? and content like ? and author like ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,"%"+title+"%");
            pstm.setString(2,"%"+content+"%");
            pstm.setString(3,"%"+author+"%");
            rs = pstm.executeQuery();
            while (rs.next()){
                int cno = rs.getInt("cno");
                String title1 = rs.getString("title");
                String content1 = rs.getString("content");
                int author1 = rs.getInt("author");
                Date date = rs.getDate("date");
                int likes = rs.getInt("likes");
                int dislike = rs.getInt("dislike");
                int open = rs.getInt("open");
                String nickname = rs.getString("nickname");
                cultures.add(new Culture(cno,title1,content1,author1,date,likes,dislike,nickname,open));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cultures;
    }

    public List<Culture> queryByAuthor(int author) {
        List<Culture> cultures = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            String sql="select cno,title,content,author,date,likes,dislike,nickname,open " +
                    "from culture c,user u where c.author=u.uid and author = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,author);
            rs = pstm.executeQuery();
            while (rs.next()){
                int cno = rs.getInt("cno");
                String title = rs.getString("title");
                String content = rs.getString("content");
                Date date = rs.getDate("date");
                int likes = rs.getInt("likes");
                int dislike = rs.getInt("dislike");
                String nickname = rs.getString("nickname");
                int open = rs.getInt("open");

                cultures.add(new Culture(cno,title,content,author,date,likes,dislike,nickname,open));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cultures;
    }

    public Culture queryByCno(int cno) {
        Culture culture = new Culture();
        try {
            conn = DBUtils.getConnection();
            String sql="select cno,title,content,author,date,likes,dislike,nickname,open " +
                    "from culture c,user u where c.author=u.uid and cno = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,cno);
            rs = pstm.executeQuery();
            while (rs.next()){
                String title = rs.getString("title");
                String content = rs.getString("content");
                int author = rs.getInt("author");
                Date date = rs.getDate("date");
                int likes = rs.getInt("likes");
                int dislike = rs.getInt("dislike");
                String nickname = rs.getString("nickname");
                int open = rs.getInt("open");
                culture =  new Culture(cno,title,content,author,date,likes,dislike,nickname,open);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return culture;
    }

    public boolean updateByCno(Culture culture) throws Exception {
        conn = DBUtils.getConnection();
        String sql="update culture set title=?,content=?,open=?  where cno = ?";
        pstm = conn.prepareStatement(sql);
        pstm.setString(1,culture.getTitle());
        pstm.setString(2,culture.getContent());
        pstm.setInt(3,culture.getOpen());
        pstm.setInt(4,culture.getCno());
        return pstm.executeUpdate()>0;
    }

    public boolean delByCno(int cno) throws Exception {
        new CommentDao().delByCno(cno);
        conn = DBUtils.getConnection();
        String sql="delete from culture where cno = ?";
        pstm=conn.prepareStatement(sql);
        pstm.setInt(1,cno);
        return pstm.executeUpdate()>0;
    }

    public boolean updateNum(int type,int cno) throws Exception {
        conn = DBUtils.getConnection();
        String sql="";
        if (type==1){
            sql = "update culture set likes = likes+1 where cno = ?";
        }else{
            sql = "update culture set dislike = dislike+1 where cno = ?";
        }
        pstm=conn.prepareStatement(sql);
        pstm.setInt(1,cno);
        return pstm.executeUpdate()>0;
    }
}
