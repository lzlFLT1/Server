


#include<string.h> 
	char s1[10] = "hello world",s2[10] = "kasei love wlt",s3[25];
	strcpy(s1, s2);//复制字符串 s2 到字符串 s1。
	strcat(s1, s2);//连接字符串 s2 到字符串 s1 的末尾。
	strlen(s1);//返回字符串 s1 的长度。
	strcmp(s1, s2);//如果 s1 和 s2 是相同的，则返回 0；如果 s1<s2 则返回小于 0；如果 s1>s2 则返回大于 0。
	strchr(s1, ch);//返回一个指针，指向字符串 s1 中字符 ch 的第一次出现的位置。
	strstr(s1, s2);//返回一个指针，指向字符串 s1 中字符串 s2 的第一次出现的位置 
	
	
#include <cmath>	
	double cos(double);//该函数返回弧度角（double 型）的余弦。
	double sin(double);//该函数返回弧度角（double 型）的正弦。
	double tan(double);//该函数返回弧度角（double 型）的正切。
	double log(double);//该函数返回参数的自然对数。
	double pow(double, double);//假设第一个参数为 x，第二个参数为 y，则该函数返回 x 的 y 次方。
	double hypot(double, double);//该函数返回两个参数的平方总和的平方根，也就是说，参数为一个直角三角形的两个直角边，函数会返回斜边的长度。
	double sqrt(double);//该函数返回参数的平方根。
	int abs(int);//该函数返回整数的绝对值。
	double fabs(double);//该函数返回任意一个十进制数的绝对值。
	double floor(double);//该函数返回一个小于或等于传入参数的最大整数
