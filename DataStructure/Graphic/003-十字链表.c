/*Ԥ���룺������������������������������������������������������������������������������������ */


/*�궨�壺����������������������������������������������������������������������������������*/
#defin MAXVERTEXNUM 100
#defin MAXARCNUM 100

/*ͷ�ļ�����������������������������������������������������������������������������������������*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"MyCode"

/*ȫ�ֱ�����������������������������������������������������������������������������������������*/  

//ʮ�����������ṹ 
/*struct VertexNode
{
	char info; //����ö������Ϣ 
	struct EdgeNode *out;//ָ���Ըö���Ϊ��ͷ�ĵ�һ������� 
	struct EdgeNode *in;//ָ���Ըö���Ϊ��β�ĵ�һ������� 
};*/

//ʮ������߱�Ļ���arc�����ṹ
struct EdgeNode//���л������ͷ�ڵ��ͼ�ڵ� 
{
	int headVertex;//�û���ͷ����λ�� 
	int tailVertex;//�û���β����λ�� 
	int info;//������Ϣ
	struct EdgeNode *hLink;//ָ��ͷ��ͬ����һ���� 
	struct EdgeNode *tLink;//ָ��β��ͬ����һ���� 
}; 

//ʮ������orthogonal list����ʾ��ͼ�ṹ
struct OLGraph
{
	struct EdgeNode vList[MAXVERTEXNUM];//ͼ�������� 
	int vertexNum;//����ͼ�Ķ����� 
	int edgeNum; //����ͼ�ı��� 
};

struct arc
{
	int start;//����� 
	int end;//���յ� 
	int info;
};
char vertex[MAXVERTEXNUM];
struct arc edge[MAXARCNUM];


/*����������������������������������������������������������������������������������������������*/

struct OLGraph * creatOLGraph(char vertex[],struct arc edge);
/*����˵��������һ��ʮ������������ͼ 
 *�������壺
 *����ֵ���壺 
 */ 

/*�������壺������������������������������������������������������������������������������������*/
struct OLGraph * creatOLGraph(char vertex[],struct arc edge[])
{
	int i = 0;
	int k = 0;
	struct EdgeNode *p = NULL; 
	struct EdgeNode *h[100];
	struct EdgeNode *t[100];
	struct OLGraph *g;
	
	
	scanf("%d,%d",&(g->vertexNum),&(g->edgeNum));//���붥�����ͻ���
	
	for(;i < g->vertexNum;i++)
	{
		g->vList[i].info = vertex[i];//���붥����Ϣ
		g->vList[i].hLink = NULL; 
		g->vList[i].tLink = NULL; //��ʼ��ָ�� 
	} 
	for(i = 0;i < g->vertexNum;i++)
	{
		h[i] = g->vList[i].hLink;
	}
	for(i = 0;i < g->vertexNum;i++)
	{
		t[i] = g->vList[i].tLink;
	}
	
	for(;k < g->edgeNum;k++)
	{
		p = (struct EdgeNode *)malloc(sizeof(struct EdgeNode));
		p->headVertex = edge[k].start;
		p->tailVertex = edge[k].end;
		p->info = edge[k].info;
		p->hLink = NULL;
		p->tLink = NULL;
		
		if(h[edge[k].start].hLink == NULL)
		{
			g->vList[edge[k].start].hLink = p;
		}
		h[edge[k].start].hLink = p;
		
		if(t[edge[k].end].tLink == NULL)
		{
			g->vList[edge[k].end].tLink = p;
		}
		t[edge[k].end].tLink = p;
	}
}