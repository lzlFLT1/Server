public class StreamUtil {


    /** todo 将输入流转化成输出流 
     * */
    public static void is2os(InputStream is, OutputStream os) throws IOException {
        if (is == null || os == null) {
            return ;
        }
        BufferedInputStream bis = new BufferedInputStream(is, 2048);
        byte[] buffer = new byte[2048];
        int count = 0;
        while((count = bis.read(buffer)) != -1){
            os.write(buffer, 0, count);
        }
    }
    
    /** todo 将输出流转化成输入流 
     * 使用 ByteArrayOutputStream 和 ByteArrayInputStream
     * 适用于数据量小的情况
     * */
    public static void os2is(){
    
    }
    
    /** todo 将输出流转化成输入流 
     * 使用 PipedOutputStream 和 PipedInputStream
     * 适用于数据量大的情况
     * @trap 必须启动两个线程，否则死锁
     * */
    public static void os2is(){
    
    }
    
    /** todo 将输出流转化成输入流 
     * 使用 CircularByteBuffer 
     * */
    public static void os2is(){
    
    }
}
