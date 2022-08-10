## 导出GIT仓库（带提交记录）

#### 1. 创建新仓库A

GITLAB上创建一个新的仓库A



#### 2. 原仓库B分支代码pull到本地

```shell
# 克隆原仓库
git clone http://192.168.34.2/bigdata/bigdata-web-service.git
# 切换到需要导出的分支，以branch_v3.5.3.0_release为例
git checkout branch_v3.5.3.0_release
# 拉取最新代码
git pull
```



#### 3. 切换远程仓库到A，推送分支到A

```shell
# 切换到远程仓库A
git remote set-url origin http://192.168.34.2/test1/a.git
# 推送分支代码到A
git push
```



#### 4. 仓库迁移

将仓库A导出，压缩后，提交给阿杜，之后云桌面内解压推送到云桌面环境的库

```shell
# 导出
git clone --bare http://192.168.34.2/test1/a.git
# 压缩a.git，例如 a.git.zip
# 传输到云桌面，解压
# 导入
git push --mirror http://gitlab.com/xxxx/xxxxx.git
```

**ps. 慎重使用 “push --mirror”，此操作会将远程库完全被本地覆盖，务必保证要导入的库是可被覆盖的。**

