public class FileSystemUti {

    
    /** Create 
     * */
    public static Boolean fileSystemCreate(File file, Boolean isDirectory) {
        if(file.exists() && file.isDirectory() == isDirectory){ // 如果 File 实例已存在 且 类型跟指定的类型相同，则直接返回 true
            return true;
        }
        if(file.exists() && file.isDirectory() != isDirectory){ // 如果 File 实例已存在 且 类型跟指定的类型不同，则直接返回 false
            return false;
        }
        if (isDirectory) { // 如果 File 实例是目录 且 不存在，则创建目录，创建成功返回 true
            return file.mkdirs();
        }

        // 如过 File 实例是文件
        File parentFile = file.getParentFile();
        if(!parentFile.exists()){ // 如果父目录不存在
            if(parentFile.mkdirs()){ // 如果创建父目录成功
                return fileSystemCreateNewFile(file);
            }
        }
        return fileSystemCreateNewFile(file);
    }
    private static Boolean fileSystemCreateNewFile(File file){
        Boolean result = false;
        try {
            result = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return result;
    }
    
    /** Delete
     * */
    public static Boolean delete(File file){
        File[] subFileAry = file.listFiles();
        if(subFileAry != null && subFileAry.length != 0){
            for (File item : subFileAry) {
                if(!delete(item)){
                    return false;
                }
            }
        }
        // 后置递归退出条件
        return file.delete();
    }
    
    /** Copy 文件目录拷贝前置检查函数
     * @trap 坑： cover 只对文件跟文件同名有效，对目录跟目录同名、目录跟文件同名、文件跟目录同名无效
     * */
    public static Boolean copy(File file, File directory, Boolean cover) {
        // 被复制文件 及 目标目录存在性判断
        if ( file == null || !file.exists() || directory == null || !directory.exists() ) {
            return false;
        }
        // 同名判断：分为文件同名 和 目录同名
        File destinationFile = new File(directory, file.getName());
        if(destinationFile.exists() && file.isDirectory()){
            // 如果拷贝的是目录，且存在同名问题，那么直接返回 false
            // 即 目录跟目录同名、目录跟文件同名
            return false;
        }
        if (destinationFile.exists() && destinationFile.isDirectory()) {
            // 文件跟目录同名
            return false;
        }
        if(!cover){
            return false; // 存在同名文件
        }
        return executeCopy(file, directory);
    }



    /** todo 拷贝动作实际执行函数
     * */
    public static Boolean executeCopy(File src, File dest){
        Boolean result = false;
        if(src.isFile()){
            result = pureFileCopy(src, dest); // 递归退出条件
        } else {
            File subDir = new File(dest, src.getName());
            subDir.mkdir();
            File[] files = src.listFiles();
            for (File item : files) {
                result = executeCopy(item, subDir);
            }
        }
        return result;
    }

    /** 纯粹的文件拷贝
     * @param file file 实例必须对应的是一个文件，不能是目录
     * @param dir dir 实例必须对应的是一个目录，不能是文件
     * @trap 坑：1.必须保证 dir 目录下没有同名的文件和同名的目录
     * */
    public static Boolean pureFileCopy(File file, File dir){
        BufferedInputStream bis =  null;
        BufferedOutputStream bos = null;
        Boolean result = false;
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            bos = new BufferedOutputStream(new FileOutputStream(new File(dir, file.getName())));
            result = bufferedIs2Os(bis, bos, 1024);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return result;
    }


    /** todo 将缓冲输入流写入到一个缓冲输出流中去，完成后关闭输入流和输出流
     * */
    public static Boolean bufferedIs2Os(BufferedInputStream bis, BufferedOutputStream bos, Integer bufferSize) {
        try {
            byte[] buffer = new byte[bufferSize];
            int count = 0;
            while ((count = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, count);
            }
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try{
                if (bis != null) { bis.close(); }
                if (bos != null) { bos.close(); }
            }catch (IOException e) {
                e.printStackTrace();
            }

        }
        return true;
    }

}
