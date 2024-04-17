package com.dao;

import com.model.Comment;
import com.model.Culture;
import com.util.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {

    private Connection conn;
    private PreparedStatement pstm;
    private Statement stm;
    private ResultSet rs;

    public boolean add(Comment comment) throws Exception {
        conn = DBUtils.getConnection();
        String sql="insert into comment(cno,author,content,date)values(?,?,?,?)";
        pstm=conn.prepareStatement(sql);
        pstm.setInt(1,comment.getCno());
        pstm.setInt(2,comment.getAuthor());
        pstm.setString(3,comment.getContent());
        pstm.setDate(4,comment.getDate());
        return pstm.executeUpdate()>0;
    }

    public List<Comment> queryByCno(int cno) {
        List<Comment> comments = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            String sql="select cid,o.author,o.content,o.date,nickname from comment o,culture c,user u  " +
                    "where o.cno = c.cno and o.author = u.uid and c.cno = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,cno);
            rs = pstm.executeQuery();
            while (rs.next()){
                int cid = rs.getInt("cid");
                String content = rs.getString("content");
                int author = rs.getInt("author");
                Date date = rs.getDate("date");
                String nickname = rs.getString("nickname");
                comments.add(new Comment(cid,cno,author,content,date,nickname));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return comments;
    }

    public boolean updateByCid(int cid) throws Exception {
        conn = DBUtils.getConnection();
        String sql="update comment set title=?,content=?,author,date where cid = ?";
        pstm = conn.prepareStatement(sql);
        pstm.setInt(1,cid);
        return pstm.executeUpdate()>0;
    }

    public boolean delByCid(int cid) throws Exception {
        conn = DBUtils.getConnection();
        String sql="delete from comment where cid = ?";
        pstm=conn.prepareStatement(sql);
        pstm.setInt(1,cid);
        return pstm.executeUpdate()>0;
    }

    public boolean delByCno(int cno) throws Exception {
        conn = DBUtils.getConnection();
        String sql="delete from comment where cno = ?";
        pstm=conn.prepareStatement(sql);
        pstm.setInt(1,cno);
        return pstm.executeUpdate()>0;
    }
}
