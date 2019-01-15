public class SqlUtil{
  
  /** todo 动态 sql 裁剪
     * @param prefix 裁剪后需要添加的前缀，如果裁剪后为空串，则不添加
     * @param prefixOverride 需要删除的前缀，多个 '|' 分隔
     * @param suffix 裁剪后需要添加的后缀， 如果裁剪后为空串，则不添加
     * @param suffixOverride 需要删除的后缀
     * @return 返回裁剪后的字符串
     * */
    public static String dynamicSqlTrim(String prefix, String prefixOverride, String suffix, String suffixOverride, String content){

        if(content == null || "".equals(content.trim())){ return ""; }
        if (prefix == null) { prefix = ""; }
        if (suffix == null) { suffix = ""; }
        if (prefixOverride == null) { prefixOverride = ""; }
        if (suffixOverride == null) { suffixOverride = ""; }
        prefix = prefix.toLowerCase();
        suffix = suffix.toLowerCase();
        prefixOverride = prefixOverride.toLowerCase();
        suffixOverride = suffixOverride.toLowerCase();
        content = content.toLowerCase();

        String[] prefixOverrideAry = prefixOverride.split("\\|");
        String[] suffixOverrideAry = suffixOverride.split("\\|");
        for (String item : prefixOverrideAry) {
            if ("".equals(item)) {
                continue ;
            }
            content = content.trim();
            if(content.startsWith(item)){
                content = content.substring(item.length());
            }
        }
        for (String item : suffixOverrideAry) {
            if ("".equals(item)) {
                continue ;
            }
            content = content.trim();
            if (content.endsWith(item)) {
                content = content.substring(0, content.length() - item.length());
            }
        }

        if(content.trim().equals("")){
            return "";
        }
        
        return prefix + " " + content + " " + suffix;
    }
  
}
