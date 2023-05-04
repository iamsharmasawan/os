#include <iostream>
#include <vector>
using namespace std;
int main()
{
int ch, i, j;
vector<vector<int>> dir_table;
vector<int> a(3, 0);
while (true)
{
cout << "1.Enter a file into hard disk: " << endl;
cout << "2. Check the table in " << endl;
cout << "3. search for the blocks of a file: " << endl;
cout << "Enter your choice: ";
cin >> ch;
if (ch == 1)
{
cout << "Enter the file id, starting address and length: ";
for (i = 0; i < 3; i++)
{
cin >> a[i];
}
int file_start = a[1];
int file_end = a[1] + a[2];
bool allocated = false;
for (i = 0; i < dir_table.size(); i++)
{
if (file_start >= dir_table[i][1] && file_end >=
dir_table[i][2])
{
continue;
}
else if (file_start <= dir_table[i][1] && file_end <=
dir_table[i][2])
{
continue;
}
else
{
allocated = true;
break;
}
}
if (!allocated)
{
dir_table.push_back(a);
cout << "File saved!!" << endl;
}
else
{
cout << "File couldn't be allocated" << endl;
}
}
else if (ch == 2)
{
for (i = 0; i < dir_table.size(); i++)
{
for (j = 0; j < dir_table[0].size(); j++)
{
cout << dir_table[i][j] << " ";
}
cout << endl;
}
}
else if (ch == 3)
{
int file_id;
cout << "Enter the file id: ";
cin >> file_id;
for (i = 0; i < dir_table.size(); i++)
{
if (dir_table[i][0] == file_id)
{
cout << "File id is: " << dir_table[i][0] << endl;
int start = dir_table[i][1];
int end = dir_table[i][2];
cout << "Blocks allocated to this file are: ";
for (j = start; j < end; j++)
{
cout << j << " ";
}
break;
}
}
cout << endl;
}
else
{
exit(0);
}
}
return 0;
}