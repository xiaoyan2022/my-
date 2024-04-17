#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define   m   15	
#define   n   50
#define   infinity       99999

#ifndef WIN32
#define _snprintf snprintf
#endif

typedef struct node
{
   float distence;		
   int  vexnode;		
   struct node *next;
}Arcnode;

typedef struct vertexnode
{
	char name[30];
	char information[100];
	
	Arcnode* head;
} Line;

typedef struct  adjlist
{
	
	Line point[m];
	int  arcnum;	
	int  vexnum;	
} graph;

typedef struct queue
{
     int father;
     int son;
     struct queue *next;    
}queue;

typedef struct  mst_point
{
    int father;
    int son;
    struct mst_point *next;
}mst_point;

int line_add_one_node(Line* pline, Arcnode* p);

void init_matrix(float (*matrix) [m])
{
	int x, xd;
	for(x = 0; x < m; x++)
	{
		for(xd = 0; xd < m; xd++)
		{
			matrix[x][xd] = 99999;	
		}
	}
}

void init_graph(graph *g)
{
	int iii;
	Arcnode* arc;
	
    memset(g, 0, sizeof(graph));

	for(iii = 0; iii < m; iii++)
	{
		arc = (Arcnode*)malloc(sizeof(Arcnode));
		arc->next = NULL;
		g->point[iii].head = arc;
	}
}


void creat_graph(graph* g, float (*matrix)[m], FILE *fp)
{
	char ch[256];
	Arcnode node;
	
	init_graph(g);
	init_matrix(matrix);

	printf("输入创建地址的数量(必须小于%d):", m);
	scanf("%d", &g->vexnum);
	getchar();
	if(g->vexnum < 0 || g->vexnum > m)
	{
		printf("错误数量 = %d\n", g->vexnum);
		return;
	}

	_snprintf(ch, 256, "%d\n", g->vexnum);
	fwrite(ch, strlen(ch), 1, fp);
	int xx, num, jj;
	int sum = 0;	
	for(xx = 0; xx < g->vexnum; xx++)
	{
		printf("=== [%d] ===\n", xx);
		
		printf("输入地址名称:");
		scanf("%s", g->point[xx].name);

		_snprintf(ch, 256, "%s\n", g->point[xx].name);
		fwrite(ch, strlen(ch), 1, fp);
		
		printf("地址描述信息:");
		scanf("%s", g->point[xx].information);

		printf("输入边的数量:");
		scanf("%d", &num);
		getchar();
		printf("\n");

		_snprintf(ch, 256, "%s...%d\n", g->point[xx].information, num);
		fwrite(ch, strlen(ch), 1, fp);

		for(jj = 0; jj < num; jj++)
		{
			printf("输入边连接结点的地址(索引值):");
			scanf("%d", &node.vexnode);
			getchar();
			printf("输入边的长度:");
			scanf("%f", &node.distence);

			_snprintf(ch, 256, "%d %.6f\n", node.vexnode, node.distence);
			fwrite(ch, strlen(ch), 1, fp);

			
			matrix[xx][node.vexnode] = node.distence;
		
			line_add_one_node(&g->point[xx], &node);

			sum++;		
		}
	}

	
	g->arcnum = sum/2;
	
	printf("边的数量 = %d\n", g->arcnum);	
}

void test(graph *g,float (*matrix)[m])
{
	Arcnode *arc;
	
	printf("the matrix is as follows:\n");
    printf("%d\n", g->vexnum);
	int nx, vx;

#if 1	
    for(nx = 0; nx < g->vexnum; ++nx)
    {
        for(vx = 0; vx < g->vexnum; ++vx)
        {
            printf("%6.1f  ", matrix[nx][vx]);
        }
        printf("\n");
    }
    printf("\n");
    printf("%d\n", g->vexnum);
#endif	
	
    for(nx = 0; nx < g->vexnum; ++nx)
    {

        arc=g->point[nx].head->next;
        printf("point connected to '%s':",g->point[nx].name);
        while(arc)
        {
            printf(" (%s,distence:%.1f) ", g->point[arc>arc].name,arc->distence);
            arc=arc->next;
        }
        printf("\n");
        printf("information:%s", g->point[nx].information);
        printf("\n\n\n");
    }

}

queue* init_queue()
{
	queue* que = NULL;

	que = (queue*)malloc(sizeof(queue));
	que->father = -1;
	que->son = -1;
	que->next = NULL;
	
	return que;
}

int empty(queue *que)
{
	if(que->next == NULL)
		return 1;
	else
		return 0;
}

void push(queue *h, int i, int j)   
{
	queue* que = NULL;

	que = init_queue();
	que->father = i;
	que->son = j;

	
	if(NULL == h->next){
		h->next = que;
		return;
	}
	
	que->next = h->next;
	h->next = que;
}

void pop(queue *h, int* i, int* j)
{
	queue* que;
	
	
	if(NULL == h->next)
	{
		return;
	}
	
	que = h->next;
	if(NULL == que->next)
	{
		
		*i = que->father;
		*j = que->son;

		free(que);	
		h->next = NULL;
		return;
	}
	
	h->next = que->next;
	*i = que->father;
	*j = que->son;

	free(que);	

	return;	
}




int get_next(graph* g, int* father, int* son)
{
	return 0;
}

int contin_find(graph*g, int father, int son, int start)
{
	return 0;
}

void dfs_opeb(graph *g, queue *head, int start, int end, int visited[])
{
	queue* que;
	int x, y;
	Arcnode *arc;
	int nstart;
	
	if(start == end)
	{
		push(head, -1, start);	
	
		que = head->next;
		printf("访问路径:\n");
		while(NULL != que)
		{
			if(NULL == que->next)
			{
				printf("%s\n", g->point[que->son].name);
				
			}
			else
			{
				printf("%s <-- ", g->point[que->son].name);
			}
			que = que->next;
		}
		pop(head, &x, &y);
		
		visited[y] = 0;
		return;
	}

	visited[start] = 1;	
	push(head, -1, start);	

	
    arc = g->point[start].head->next;
	if(NULL == arc)
		return;
	
#if 0
    printf("\nope point = '%s'\n", g->point[start].name);
#endif

    while(NULL != arc)
    {
		nstart = arc->vexnode;
#if 0
		printf("操作连接结点 = %s\n", g->point[new_start].name);
#endif
		
		if(0 == visited[nstart])
		{
			
			dfs_opeb(g, head, nstart, end, visited);
		}

		if(NULL == arc->next)
		{
			
			pop(head, &x, &y);
		
			visited[y] = 0;			
		}

		arc = arc->next;
    }
	

}

void allways_bttps(graph *g, queue *head, int start, int end)
{

	int vis[m] = {0};
	
	if(start == end){
		printf("Not find, start == end\n");
		return;
	}
	if(start >= m || end >= m || start < 0 || end < 0){
		printf("err addr start = %d, end = %d\n", start, end);
		return;
	}

	dfs_opeb(g, head, start, end, vis);

}

void dijkstra(graph *g, float (*matrix)[m],int start,int end,int dist[m],int path[m][m+1])
{
	

	float xsz;
	int pop[m] = {0};
    int zzz[m];     
	int fid;
	int i, j, kk;
	int min[m];
		float ttt;

	if(start == end){
		printf("Not find, start == end\n");
		return;
	}
	if(start >= m || end >= m || start < 0 || end < 0){
		printf("err addr start = %d, end = %d\n", start, end);
		return;
	}
	

	for(i = 0; i < m; i++)
	{
		pop[i] = 0;
		zzz[i] = 0;	
		dist[i] = matrix[start][i];

		min[i] = -1;
	}

	
	zzz[start] = 1;
	dist[start] = 0;

	for(i = 1; i < g->vexnum; i++)
	{
#if 0
		printf("ope i = %d\n", i);
#endif
		
		xsz = infinity;

		for(j = 0; j < g->vexnum; j++)
		{
			if(zzz[j] == 0 && dist[j] < xsz)
			{
				xsz = dist[j];
				kk = j;	
			}
		}
#if 0
		printf("get min = %f, k = %d, name = %s\n",
			min, k, g->point[k].name);
#endif
		zzz[kk] = 1;	

		
		for(j = 0; j < g->vexnum; j++)
		{
			if(infinity == matrix[kk][j])
			{
				ttt = infinity;
			}
			else
			{
				ttt = xsz + matrix[kk][j];
			}

			
			if(0 == zzz[j] && (ttt < dist[j]))
			{
#if 0
				printf("update tmp = %f, k = %d\n", tmp, k);
#endif
				dist[j] = ttt;
				pop[j] =kk;
			}
		}
	
	}

#if 0
	for(i = 0; i < g->vexnum; i++)
	{
		printf("%s <--> %s, prev = %d\n",
			g->point[start].name,
			g->point[i].name,
			prev[i]);
	}
#endif
	
	fid = pop[end];
	for(i = 0; i < g->vexnum;i++)
	{
		if(0 == fid)
			break;
		min[i] = fid;
#if 0
		printf("get find idx = %d\n", find_idx);
#endif
		fid = pop[fid];
	}

	printf("最短路径:\n");
	printf("%s --> ", g->point[start].name);
	while(i>= 0)
	{
		i--;
		if(i < 0)
			break;	
		printf("%s --> ", g->point[min[i]].name);
	}//end while
	printf("%s", g->point[end].name);
}


mst_point* prim(graph* g,float(*matrix)[m],int start)
{
	mst_point *mpt, *xx, *xzz;
    int z, y, l;
	float cxz;
    int zxc=0;         

	
	int path_idx[m] = {-1};
   
    float weights[m];   

	
	path_idx[zxc++] = start;

	
	for(z = 0; z < g->vexnum; z++)
	{
		weights[z] = matrix[start][z];
	}

	
	weights[start] = 0;
	
	for(z = 0; z < g->vexnum; z++)
	{
		if(start == z)
			continue;

		y = 0;
		l = 0;
		cxz = infinity;
		
		while(y < g->vexnum)
		{
			if(weights[y] != 0 && weights[y] < cxz)
			{
				
				cxz = weights[y];
				l = y;
			}
			y++;
		}

	
		path_idx[zxc++] = l;

		
		weights[l] = 0;

		
		for(y = 0; y < g->vexnum; y++)
		{
			if(weights[y] != 0 && matrix[l][y] < weights[y])
			{
				weights[y] = matrix[l][y];
			}
		}
	}
#if 0
	printf("最短路径:\n");
	for(i = 0; i < index; i++)
	{
		if(i == index-1)
		{
			printf("%s", g->point[path_idx[i]].name);
		}
		else
		{
			printf("%s --> ", g->point[path_idx[i]].name);
		}
	}
	printf("\n");
#endif

	mpt = (mst_point*)malloc(sizeof(mst_point));
	xzz = mpt;
	
	
	for(z = 0; z < zxc; z++)
	{
		xx = (mst_point*)malloc(sizeof(mst_point));
		xx->son = path_idx[z];
		xx->next = NULL;

		xzz->next = xx;
		xzz = xx;
		
	}

	return mpt;
}

void test_mst(mst_point *j)
{
    mst_point* mpt;
    mpt=j->next;
	
    printf("the MST tree is:\n");
    while(mpt)
    {
        printf("(%d,%d)  ", mpt->father,mpt->son);
        mpt=mpt->next;
    }
    printf("\n");
}

int information_get_num(char* pbufb)
{
	int cxz, dd;
	char chh;
	
	dd = strlen(pbufb);
	
	for(cxz = 0; cxz < dd; cxz++)
	{
		chh = pbufb[cxz];
		if('\r' == pbufb[cxz+1] || '\n' == pbufb[cxz+1] || '\0' == pbufb[cxz+1])
			break;
	}//end for

	return chh - '0';
}

int line_add_one_node(Line* pline, Arcnode* p)
{
	Arcnode* arc = NULL;
	Arcnode* arcv;

	arc = (Arcnode*)malloc(sizeof(Arcnode));
	memcpy(arc, p, sizeof(Arcnode));
	arc->next = NULL;

	arcv = pline->head;

	
	if(NULL == arcv)
	{
		pline->head = arc;
		return 1;
	}

	while(NULL != arcv->next)
	{
		arcv = arcv->next;
	}

	arcv->next = arc;

	return 0;
}

int str_get_node(char* pstr, Arcnode* pnodea)
{
	int cxzc, xczxc, i;

	cxzc = pstr[0] - '0';

	pnodea->next = NULL;
	pnodea->vexnode = cxzc;

	xczxc = strlen(pstr);

	for(i = 0; i < xczxc; i++)
	{
		if(' ' == pstr[i])
		{
			i++;
			pnodea->distence = atof(&pstr[i]);

#if 0
			printf("get_node %d %f\n", pnode->vexnode, pnode->distence);
#endif
			
			return 1;
		}
	}

	return 0;
}

void read(graph* g, float (*matrix)[m], FILE *fp)
{
	int aa, cxzc, num, cxzcza, zzzccc, l;
	char buf[256];
	Arcnode nodea;
	int line_num = 0;
	
	
	init_graph(g);
	init_matrix(matrix);

	
	memset(buf, 0, 256);
	fgets(buf, 256, fp);
	g->vexnum = atoi(buf);

#if 1
	printf("地点数量 = %d\n", g->vexnum);
#endif
	
	for(cxzc = 0; cxzc < g->vexnum; cxzc++)
	{
		memset(buf, 0, 256);
		fgets(buf, 256, fp);
	
		l = strlen(buf);
		for(zzzccc = 0; zzzccc < l; zzzccc++)
		{
			if('\r' == buf[zzzccc] || '\n' == buf[zzzccc])
				break;
			g->point[cxzc].name[zzzccc] = buf[zzzccc];
		}

		memset(buf, 0, 256);
		fgets(buf, 256, fp);

		
		num = information_get_num(buf);
		
	
		l = strlen(buf);
		for(zzzccc = 0; zzzccc < l; zzzccc++)
		{
			if('\r' == buf[zzzccc] || '\n' == buf[zzzccc] || '.' == buf[zzzccc])
				break;
			g->point[cxzc].information[zzzccc] = buf[zzzccc];
		}		

		
#if 0
		printf("get num = %d\n", num);
#endif
		for(cxzcza = 0; cxzcza < num; cxzcza++)
		{
			memset(buf, 0, 256);
			fgets(buf, 256, fp);

			str_get_node(buf, &nodea);
		
			matrix[cxzc][nodea.vexnode] = nodea.distence;

		
			line_add_one_node(&g->point[cxzc], &nodea);

			line_num++;
		}

	}

	
	g->arcnum = line_num/2;
	printf("边的数量 = %d\n", g->arcnum);
#if 0
	printf("test print:\n");
	test(g, matrix);
#endif
	
}

void display(graph *g)
{
	Arcnode *arc;
	
	
    printf("城市节点数 = %d\n", g->vexnum);
	int i, j;
    for(i = 0; i < g->vexnum; ++i)
    {
		j = 0;
        arc=g->point[i].head->next;
		printf("第[%d]个地点信息:\n", i);
        printf("当前地点名称:%s\n",g->point[i].name);
		printf("城市描述:%s\n", g->point[i].information);
        while(arc)
        {
            printf("[%d] 与 %s 距离 = %.1f\n",
				j++,
				g->point[arc->vexnode].name,
				arc->distence);
			
            arc=arc->next;
        }
        printf("=== === === === === ===\n");
        printf("\n");
    }
}



void display_mst(graph* g, mst_point *head)
{
	mst_point *mpt, *zzz;

	mpt = head->next;

	if(NULL == mpt)
		return;

	printf("最短路径:\n");
	while(mpt)
	{
		printf("%s ", g->point[mpt->son].name);
		zzz = mpt;
		mpt = mpt->next;
		if(NULL != mpt)
		{
			printf("--> ");
		}
		free(zzz);	
	}
	printf("\n");
	
}

void add(graph *g,float(*matrix)[m],int start,int end,float distence)
{
	Arcnode aec;
	
	if(start < 0 || start >= g->vexnum){
		printf("错误 start 结点索引 = %d\n", start);
		return;
	}
	if(end < 0 || end >= g->vexnum){
		printf("错误 end 结点索引 = %d\n", end);
		return;
	}
	if(start == end){
		printf("错误结点 start == end\n");
		return;
	}
	
	if(infinity != matrix[start][end])
	{
		printf("边已经存在, 长度 = %f\n", matrix[start][end]);
		return;
	}


	matrix[start][end] = distence;
	matrix[end][start] = distence;

	
	aec.distence = distence;
	aec.vexnode = end;

	line_add_one_node(&g->point[start], &aec);

	
	aec.distence = distence;
	aec.vexnode = start;
	line_add_one_node(&g->point[end], &aec);	

	printf("添加一条边 %s <--> %s, 长度:%f\n",
		g->point[start].name,
		g->point[end].name,
		distence);

	printf("添加边完成!\n");
}

void cut(graph *g,float(*matrix)[m],int start,int end)
{
	Arcnode *aec, *cxzcz;
	
	if(start < 0 || start >= g->vexnum){
		printf("错误 start 结点索引 = %d\n", start);
		return;
	}
	if(end < 0 || end >= g->vexnum){
		printf("错误 end 结点索引 = %d\n", end);
		return;
	}
	if(start == end){
		printf("错误结点 start == end\n");
		return;
	}
	
	if(infinity == matrix[start][end])
	{
		printf("要删除边\n");
		return;
	}

	
	matrix[start][end] = infinity;
	matrix[end][start] = infinity;

	
	aec = g->point[start].head->next;
	if(NULL == aec)
		return;

	cxzcz = g->point[start].head;
	while(aec)
	{
		if(aec->vexnode == end)
		{
		
			cxzcz->next = aec->next;
#if 1
			printf("在 %s 中删除 %s 成功\n",
				g->point[start].name,
				g->point[end].name);
#endif
			free(aec);	
			break;
		}
	}

	
	aec = g->point[end].head->next;
	if(NULL == aec)
		return;

	cxzcz = g->point[end].head;
	while(aec)
	{
		if(aec->vexnode == start)
		{
			
			cxzcz->next = aec->next;
#if 1
			printf("在 %s 中删除 %s 成功\n",
				g->point[end].name,
				g->point[start].name);
#endif
			free(aec);	
			break;
		}
	}



	
}


void store_to_file(graph *g,float (*matrix)[m])
{
	FILE* fizz;
	
	Arcnode* aec;
	
	char buf[256];
	
	fizz = fopen("graph.txt","wt");

	_snprintf(buf, 256, "%d\n", g->vexnum);
	fwrite(buf, strlen(buf), 1, fizz);
	int i, j;
	int num;
	for(i = 0; i < g->vexnum; i++)
	{

		_snprintf(buf, 256, "%s\n", g->point[i].name);
		fwrite(buf, strlen(buf), 1, fizz);
		
		aec = g->point[i].head->next;

	
		num = 0;
		while(aec)
		{
			num++;
			aec = aec->next;
		}//end while

		_snprintf(buf, 256, "%s...%d\n", g->point[i].information, num);
		fwrite(buf, strlen(buf), 1, fizz);

		aec = g->point[i].head->next;
		while(aec)
		{
			_snprintf(buf, 256, "%d %.6f\n", aec->vexnode, aec->distence);
			fwrite(buf, strlen(buf), 1, fizz);

			aec = aec->next;
		}
	}
	fclose(fizz);
}



void add_point(graph *g,float (*matrix)[m])
{
	
	int a = g->vexnum;
	int num, j;
	Arcnode node;
	char ch[256];
#if 1
	printf("没有实现\n");
	return;
#endif
	
	if(g->vexnum >= m)
	{
		printf("集合满, 不可以添加\n");
		return;
	}
	g->vexnum++;	
	
	
	printf("输入地址名称:");
	scanf("%s", g->point[a].name);

	printf("地址描述信息:");
	scanf("%s", g->point[a].information);

	printf("输入边的数量:");
	scanf("%d", &num);
	getchar();
	printf("\n");

	for(j = 0; j < num; j++)
	{
		printf("输入边连接结点的地址(索引值):");
		scanf("%d", &node.vexnode);
		getchar();
		printf("输入边的长度:");
		scanf("%f", &node.distence);

	
		matrix[a][node.vexnode] = node.distence;
		matrix[node.vexnode][a] = node.distence;
		
	
		line_add_one_node(&g->point[a], &node);
		line_add_one_node(&g->point[node.vexnode], &node);
	}

	store_to_file(g, matrix);
	
}

void del_point(graph *g,float (*matrix)[m])
{
	int ccc, i;

#if 1
	printf("没有实现\n");
	return;
#endif
	
	printf("\n    places intrduction    \n");
	for(i = 0; i < g->vexnum; ++i)
	{
		printf("%d : %s\n",i,g->point[i].name);
	}
	printf("input the point you want to del:");
	scanf("%d",&ccc);
	getchar();

}
void Select(graph *g)
{



}

int main(void)
{
	 int start,end;
    int zcx;
    int ddd;
    FILE *file;
    float dxzac;
	graph gr;
    queue *head;
    float mnbvx[m][m];
   
    int dist[m];

    mst_point *Head;

	head = init_queue();

    init_matrix(mnbvx);
	 int ppz[m][m+1];
   
    while(1)
	{

    printf("                       城 市 区 域 查 询 系 统 demo                \n\n ");
    printf("      **************功能页面**************                            \n");
    printf("      **************0.地图的基本信息**************                                             \n");
    printf("      **************1.可供查询的地点及其基本信息介绍**************                                  \n");
    printf("      **************2.查询任意两点间所有的路径**************                                       \n");
    printf("      **************3.查询两点间最短路径**************                                            \n");
    printf("      **************4.查询从某点出发的最短连通路径**************                                  \n");
    printf("      **************5.路径的扩充**************                                                  \n");
    printf("      **************6.路径的撤销**************                                                  \n");
    printf("      **************7.新建整张地图**************                                                 \n");
    printf("      **************8.add point**************                                                  \n");
    printf("      **************9.delete point**************                                             \n");
    printf("      **************10.退出该系统**************                                                  \n");
    printf("\n\n  根据序号输入你的选择：   ");

    scanf("%d",&ddd);
    if(ddd==10)
        break;
    else
    {
        switch(ddd)
        {
            case 0:
            {
                  file=fopen("graph.txt","rt");
                  read(&gr,mnbvx,file);
                  fclose(file);
                  getchar();
                  getchar();
                  break;
            }
            case 1:
            { 
                file=fopen("graph.txt","rt");
                read(&gr,mnbvx,file);
                fclose(file);
                display(&gr);
                getchar();
                getchar();
                break;
            }
            case 2:
            {
                file=fopen("graph.txt","rt");
                read(&gr,mnbvx,file);
                fclose(file);
                Select(&gr);
              
				printf("input start point:");
				scanf("%d", &start);
				getchar();
				printf("input target point:");
				scanf("%d", &end);
				getchar();
				
                allways_bttps(&gr,head,start,end);
                getchar();
                getchar();
                break;
            }
            case 3:
            {
                 file=fopen("graph.txt","rt");
                 read(&gr,mnbvx,file);
                 fclose(file);
                 Select(&gr);
               
				printf("input start point:");
				scanf("%d", &start);
				getchar();
				printf("input target point:");
				scanf("%d", &end);
				getchar();
				
                 dijkstra(&gr,mnbvx,start,end,dist,ppz);
				 
                 getchar();
                 getchar();
                 break;
            }
            case 4:
            {
                file=fopen("graph.txt","rt");
                read(&gr,mnbvx,file);
                fclose(file);
                Select(&gr);
                printf("input the start point:");

                scanf("%d",&start);
                getchar();
                Head = prim(&gr,mnbvx,start);
                display_mst(&gr,Head);

                getchar();
                getchar();
                break;
            }
            case 5:
            {
                 file=fopen("graph.txt","rt");
                 read(&gr,mnbvx,file);
                 Select(&gr);
                 fclose(file);
                 printf("input the rout needed to be expend\n");
				 
                 printf("start:");  
				 scanf("%d",&start);
				 
                 printf("end:");  
				 scanf("%d",&end);
				 
                 printf("distence:");   
				 scanf("%f",&dxzac);
				 
                 printf("\n");
                 getchar();
                 add(&gr,mnbvx,start,end,dxzac);
                 printf("now,the graph should be:\n");
                 test(&gr,mnbvx);
                 getchar();
                 getchar();
                 break;
            }
            case 6:
            {
                 file=fopen("graph.txt","rt");
                 read(&gr,mnbvx,file);
                 Select(&gr);
                 fclose(file);
                 printf("input the rout needed to be cut\n");

				 printf("start:");
				 scanf("%d",&start);

				 printf("end:");
				 scanf("%d",&end);
				 
                
                 printf("\n");
                 getchar();
			
                 cut(&gr,mnbvx,start,end);
                 printf("now,the graph should be:\n");
                 test(&gr,mnbvx);
                 getchar();
                 getchar();
                 break;
            }
            case 7:
            {
                  file=fopen("graph.txt","wt");
                  creat_graph(&gr,mnbvx,file);
                  fclose(file);
                  test(&gr,mnbvx);
                  getchar();
                  break;

            }
            case 8:
            {
                  file=fopen("graph.txt","rt");

                  read(&gr,mnbvx,file);
                  Select(&gr);

                  fclose(file);
                  add_point(&gr,mnbvx);
                  test(&gr,mnbvx);

                  getchar();
                  getchar();
                  break;
            }
            case 9:
            {
                  file=fopen("graph.txt","rt");
                  read(&gr,mnbvx,file);
                  Select(&gr);
                  fclose(file);
				  
                  del_point(&gr,mnbvx);
				  
                  test(&gr,mnbvx);
                  
                  getchar();
                  getchar();
                  break;
            }
        }
    }
       

}



	return 0;
}

