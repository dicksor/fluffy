#!/bin/bash
#
# Goal
#
#		Installer java
#
# Usage:
#
#	 	 sudo ./installJava.sh 
#
# Perimetre:
#
#		Tester sous ubuntu 14.04, 16.04, 18.04
#
# Prerequis
#
#		Lisez d'abord le fichier voisin : tips.txt

# -------------------------------------------
# 			java 8
# -------------------------------------------

#sudo add-apt-repository ppa:webupd8team/java
#sudo apt-get update
#sudo apt-get install oracle-java8-installer
#sudo apt-get install oracle-java8-set-default

# -------------------------------------------
# 			java 10
# -------------------------------------------

sudo add-apt-repository ppa:linuxuprising/java
sudo apt-get update
sudo apt-get install oracle-java10-installer
sudo apt-get install oracle-java10-set-default

# -------------------------------------------
# 			check
# -------------------------------------------

echo ""
java -version
echo ""

# -------------------------------------------
# 			end
# -------------------------------------------

