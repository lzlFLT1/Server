#define MaxTreeNodeNum  100
#define DT int

struct BTree
{
	DT data[MaxTreeNodeNum];//根存储在data[1]数组单元中，data[0]空着
	int n;//当前二叉树结点个数
};