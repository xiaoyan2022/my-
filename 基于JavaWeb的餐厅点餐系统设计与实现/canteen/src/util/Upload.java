package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * ˵������servlet���ã����루�ļ�����Ҫ�ϴ���·�����ļ�������������
 * �ϴ��ļ���servlet��ȡ�����ݱ���ʹ��
 * for(FileItem item : list)����
 * @author student
 *
 */
public class Upload {
    public static void uploadFile(InputStream filestream,File savaPath,String filename){
    	//ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
        //1������һ��DiskFileItemFactory����
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //����ϴ��ļ�������������
        upload.setHeaderEncoding("UTF-8"); 
      //����һ���ļ������
       //ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺  c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
       //�����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
       filename = filename.substring(filename.lastIndexOf("\\")+1);
       String realSavePath = savaPath+"\\"+filename;
       //����һ�������
        FileOutputStream out = null;
		try {
			out = new FileOutputStream(realSavePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //����һ��������
        byte buffer[] = new byte[1024];
        //�ж��������е������Ƿ��Ѿ�����ı�ʶ
        int len = 0;
        //ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
        try {
			while((len=filestream.read(buffer))>0){
			    //ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\" + filename)����
			    out.write(buffer, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("�����������Ŀ¼:"+realSavePath);
        //�ر�������
        try {
			filestream.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //�ر������
        //ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
        //item.delete();
    }
}
