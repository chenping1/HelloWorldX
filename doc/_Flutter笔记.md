### Flutter 笔记

### 问题
#### 1.  一直Running "flutter pub get"  等待中(Linux)
问题是 环境变量根据 设置在/.bash_profile 中，一直起不了作用
查看环境变量 也没有成功
、、、
echo $PATH
echo $PUB_HOSTED_URL
、、、
处理方法: 改为放到/etc/profile 中
、、、
sudo gedit /etc/profile
然后将下面环境变量加到最后
export PUB_HOSTED_URL=https://mirrors.tuna.tsinghua.edu.cn/dart-pub
export FLUTTER_STORAGE_BASE_URL=https://mirrors.tuna.tsinghua.edu.cn/flutter
、、、

export PUB_HOSTED_URL=https://pub.flutter-io.cn
export FLUTTER_STORAGE_BASE_URL=https://storage.flutter-io.cn
重启大法，成功

#### 2. 升级Flutter 
本打算升级一下Flutter 的运行
、、、
flutter upgrade
、、、
太卡,  Flutter 中文网(https://flutterchina.club/setup-linux/) 查看 安装文档
去https://github.com/flutter/flutter/releases ，下载最新zip 包替换
、、、
flutter doctor
、、、
完犊子 问题很多 
1. The Flutter directory is not a clone of the GitHub project. (git init 项目一下)
2. git <command> [<revision>...] -- [<file>...] (版本号没有)
各种需要apt下载的更新包, 解决完一个又一个打怪似的

重新查是否有完整的sdk 包, 还是官网好
https://flutter.dev/docs/get-started/install
下载下来1.4G github release 才20M  怪不得










