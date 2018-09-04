# fatal: refusing to merge unrelated histories
Git 从 2.9.0 版本开始，预设行为不允许合并没有共同祖先的分支，需要加上 --allow-unrelated-histories 进行 pull 操作才不会出现此类错误信息。
例：git pull --allow-unrelated-histories

参考：
https://git-scm.com/docs/git-merge/2.9.0
https://stackoverflow.com/questions/37937984/git-refusing-to-merge-unrelated-histories

