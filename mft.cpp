#include <iostream>
#include <string>
using namespace std;
int main()
{
int ch;
cout << "1. Equal sized mft: " << endl;
cout << "2. Unequal sized mft: " << endl;
cin >> ch;
int mem_size, os_size;
cout << "Enter the size of MM: ";
cin >> mem_size;
cout << "Enter the size of os: ";
cin >> os_size;
mem_size = mem_size - os_size;
int block_size;
int memory_paritions[100];
int occupied[100];
int internal_frag[100];
int n, m, i, j;
if (ch == 1)
{
cout << "Enter the size of the block: ";
cin >> block_size;
n = mem_size / block_size;
for (i = 0; i < n; i++)
{
memory_paritions[i] = block_size;
occupied[i] = 0;
internal_frag[i] = 0;
}
}
else
{
cout << "Enter the number of blocks: ";
cin >> n;
cout << "Enter the size of each block one by one: ";
for (int i = 0; i < n; i++)
{
cin >> memory_paritions[i];
occupied[i] = 0;
internal_frag[i] = 0;
}
}
cout << "Enter the number of blocks you are going to enter: ";
cin >> m;
string p_id[m];
int p_size[m];
int x, total_internal_frag = 0;
cout << "Enter the id and size of each process: ";
for (i = 0; i < m; i++)
{
cin >> x >> p_size[i];
p_id[i] = "P" + to_string(x);
}
bool flag = false;
for (i = 0; i < m; i++)
{
flag = false;
for (j = 0; j < n; j++)
{
if (p_size[i] <= memory_paritions[j] && occupied[j] == 0)
{
internal_frag[j] = memory_paritions[j] - p_size[i];
cout << p_id[i] << " "
<< "assigned to block " << j << " with internal frag
" << internal_frag[j] << endl;
occupied[j] = 1;
total_internal_frag += internal_frag[j];
flag = true;
break;
}
}
if (flag == false)
{
cout << p_id[i] << " couldn't be assigned to any memory block
" << endl;
}
}
cout << endl
<< "Total internal fragmentation: " << total_internal_frag <<
endl;
return 0;
}