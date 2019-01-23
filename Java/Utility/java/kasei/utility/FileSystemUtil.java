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

}
