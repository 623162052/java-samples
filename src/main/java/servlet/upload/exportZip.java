package servlet.upload;//package upload;
//
//import java.io.InputStream;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipOutputStream;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
//public class EdOnlineTrainManagerAction extends BaseAction {
//	private static transient Log log = LogFactory.getLog(EdOnlineTrainManagerAction.class);
//
//	/**
//	 * 导出在线培训图片
//	 */
//	public void exportOnlineTrainPic(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		//设置浏览器显示的内容类型为Zip
//		response.setContentType("application/zip");
//		//设置内容作为附件下载
//	    response.setHeader("Content-Disposition", "attachment; filename= " + new String("在线培训导出图片".getBytes("GBK"), "ISO8859-1") + ".zip");
//
//	    //装饰输出流为Zip输出流
//	    ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
//	    IEdOnlineTrainSV isv = (IEdOnlineTrainSV) ServiceFactory.getService(IEdOnlineTrainSV.class);
//
//		try{
//			String flowId = HttpUtil.getAsString(request, "flowId");
//			IBOEdOnlineTrainNodeValue[] nodes = isv.queryOnlineTrainNode(flowId);
//			//读取文件的缓存
//		    byte[] buffer = new byte[1024];
//		    int length = 0;
//
//			for(int i=0; i<nodes.length; i++){
//				String fileId = String.valueOf(nodes[i].getPicUrl());
//				InputStream is = FtpMan.getFtpFileInputStream(fileId, StaticValue.CS_ED_FILE_FTP);
//				zos.putNextEntry(new ZipEntry(String.valueOf(i + 1) + ".jpg"));
//
//	            while ((length = is.read(buffer)) > 0) {
//	            	zos.write(buffer, 0, length);
//	            }
//	            zos.closeEntry();
//	            is.close();
//			}
//			zos.flush();
//	    }catch(Exception e){
//	    	e.printStackTrace();
//	    }finally{
//	    	try{
//				zos.close();
//	    	}catch(Exception err){
//	    	}
//	    }
//	}
//}
