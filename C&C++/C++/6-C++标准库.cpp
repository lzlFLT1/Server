


#include<string.h> 
	char s1[10] = "hello world",s2[10] = "kasei love wlt",s3[25];
	strcpy(s1, s2);//�����ַ��� s2 ���ַ��� s1��
	strcat(s1, s2);//�����ַ��� s2 ���ַ��� s1 ��ĩβ��
	strlen(s1);//�����ַ��� s1 �ĳ��ȡ�
	strcmp(s1, s2);//��� s1 �� s2 ����ͬ�ģ��򷵻� 0����� s1<s2 �򷵻�С�� 0����� s1>s2 �򷵻ش��� 0��
	strchr(s1, ch);//����һ��ָ�룬ָ���ַ��� s1 ���ַ� ch �ĵ�һ�γ��ֵ�λ�á�
	strstr(s1, s2);//����һ��ָ�룬ָ���ַ��� s1 ���ַ��� s2 �ĵ�һ�γ��ֵ�λ�� 
	
	
#include <cmath>	
	double cos(double);//�ú������ػ��Ƚǣ�double �ͣ������ҡ�
	double sin(double);//�ú������ػ��Ƚǣ�double �ͣ������ҡ�
	double tan(double);//�ú������ػ��Ƚǣ�double �ͣ������С�
	double log(double);//�ú������ز�������Ȼ������
	double pow(double, double);//�����һ������Ϊ x���ڶ�������Ϊ y����ú������� x �� y �η���
	double hypot(double, double);//�ú�����������������ƽ���ܺ͵�ƽ������Ҳ����˵������Ϊһ��ֱ�������ε�����ֱ�Ǳߣ������᷵��б�ߵĳ��ȡ�
	double sqrt(double);//�ú������ز�����ƽ������
	int abs(int);//�ú������������ľ���ֵ��
	double fabs(double);//�ú�����������һ��ʮ�������ľ���ֵ��
	double floor(double);//�ú�������һ��С�ڻ���ڴ���������������
