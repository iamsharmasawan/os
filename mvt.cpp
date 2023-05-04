#include <iostream>
#include <vector>
using namespace std;
int main()
{
int mem_size, os_size;
cout << "Enter the size of the memory: ";
cin >> mem_size;
cout << "Enter the size of the os: ";
cin >> os_size;
mem_size = mem_size - os_size;
int rem_size = mem_size;
int a, b, n, i, j;
cout << "Enter the number of processes you are going to enter: ";
cin >> n;
vector<int> main_memory(n, 0);
vector<int> processinmm(n, -1);
for (i = 0; i < n; i++)
{
cout << "Enter the p_id and size of the process: ";
cin >> a >> b;
processinmm[i] = a;
main_memory[i] = b;
rem_size = rem_size - b;
}
if (rem_size > 0)
{
main_memory.push_back(rem_size);
processinmm.push_back(-1);
}
while (true)
{
int ch;
cout << endl
<< "1. Enter a new process: ";
cout << endl
<< "2. Remove a process: ";
cout << endl
<< "3. print main memory and processes present: ";
cin >> ch;
if (ch == 1)
{
if (rem_size == 0)
{
cout << "Not enough remaining space: ";
}
else
{
cout << endl
<< "Enter the p_id and process size: ";
cin >> a >> b;
bool flag = false;
for (i = 0; i < main_memory.size(); i++)
{
if (b <= main_memory[i] && processinmm[i] == -1)
{
flag = true;
rem_size = rem_size - b;
cout << endl
<< "Process entered at block " << i;
if (processinmm[i] == -1)
{
if (rem_size > 0)
{
bool flag_empty = false;
for (j = 0; j < processinmm.size(); j++)
{
if (processinmm[j] == -1)
{
main_memory[j] = rem_size;
flag_empty = true;
break;
}
}
if (!flag_empty)
{
main_memory.push_back(rem_size);
processinmm.push_back(-1);
}
}
}
processinmm[i] = a;
main_memory[i] = b;
break;
}
}
if (!flag)
{
cout << endl
<< "Couldn't find a contigious, compaction will
be needed";
cout << endl
<< "TOTAL fragmentation: " << rem_size;
}
}
}
else if (ch == 2)
{
cout << "Enter the p_id of the process you want to remove: ";
cin >> a;
bool flag = false;
for (i = 0; i < n; i++)
{
if (processinmm[i] == a)
{
processinmm[i] = -1;
rem_size = rem_size + main_memory[i];
flag = true;
cout << endl
<< "Process removed!";
break;
}
}
if (!flag)
{
cout << endl
<< "No process with that p_id";
}
}
else if (ch == 3)
{
for (i = 0; i < main_memory.size(); i++)
{
cout << "process " << processinmm[i] << " assigned to
block with memory " << main_memory[i] << endl;
}
cout << "total remaining size: " << rem_size;
}
else
{
cout << endl
<< "Exiting";
exit(0);
}
}
return 0;
}