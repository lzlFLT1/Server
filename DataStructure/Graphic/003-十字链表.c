/*预编译：……………………………………………………………………………………………………………… */


/*宏定义：……………………………………………………………………………………………………………*/
#defin MAXVERTEXNUM 100
#defin MAXARCNUM 100

/*头文件包含：……………………………………………………………………………………………………………*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"MyCode"

/*全局变量：………………………………………………………………………………………………………………*/  

//十字链表顶点表结点结构 
/*struct VertexNode
{
	char info; //保存该顶点的信息 
	struct EdgeNode *out;//指向以该顶点为弧头的第一个弧结点 
	struct EdgeNode *in;//指向以该顶点为弧尾的第一个弧结点 
};*/

//十字链表边表的弧（arc）结点结构
struct EdgeNode//其中弧链表的头节点存图节点 
{
	int headVertex;//该弧的头顶点位置 
	int tailVertex;//该弧的尾顶点位置 
	int info;//弧上信息
	struct EdgeNode *hLink;//指向弧头相同的下一条弧 
	struct EdgeNode *tLink;//指向弧尾相同的下一条弧 
}; 

//十字链表（orthogonal list）表示的图结构
struct OLGraph
{
	struct EdgeNode vList[MAXVERTEXNUM];//图顶点数组 
	int vertexNum;//有向图的顶点数 
	int edgeNum; //有向图的边数 
};

struct arc
{
	int start;//弧起点 
	int end;//弧终点 
	int info;
};
char vertex[MAXVERTEXNUM];
struct arc edge[MAXARCNUM];


/*函数声明：………………………………………………………………………………………………………………*/

struct OLGraph * creatOLGraph(char vertex[],struct arc edge);
/*功能说明：创建一个十字链表存的有向图 
 *参数含义：
 *返回值含义： 
 */ 

/*程序主体：………………………………………………………………………………………………………………*/
struct OLGraph * creatOLGraph(char vertex[],struct arc edge[])
{
	int i = 0;
	int k = 0;
	struct EdgeNode *p = NULL; 
	struct EdgeNode *h[100];
	struct EdgeNode *t[100];
	struct OLGraph *g;
	
	
	scanf("%d,%d",&(g->vertexNum),&(g->edgeNum));//读入顶点数和弧数
	
	for(;i < g->vertexNum;i++)
	{
		g->vList[i].info = vertex[i];//读入顶点信息
		g->vList[i].hLink = NULL; 
		g->vList[i].tLink = NULL; //初始化指针 
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