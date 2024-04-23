Fichier La_Suite.c :

La fonction void chiffrement_texte :

Cette fonction prend en entrée la clé publique (e,n) ainsi que les noms des fichiers d'entrée et de sortie fich et res. Elle ouvre les deux fichiers en mode lecture et écriture respectivement, puis lit le texte du fichier d'entrée caractère par caractère en utilisant la fonction fgetc. Pour chaque caractère lu, la fonction calcule son chiffrement RSA en utilisant la formule c_chiffre = m^e mod n, où m est le code ASCII du caractère, e est l'exposant de la clé publique et n est le modulo de la clé publique. La fonction écrit ensuite l'entier c_chiffre dans le fichier de sortie, suivi d'un retour à la ligne. Enfin, la fonction ferme les deux fichiers avec la fonction fclose.

La fonction void dechiffrement_texte :

La fonction prend en entrée les paramètres p, q et d qui définissent la clé privée, ainsi que le nom du fichier chiffré chiff. Elle calcule d'abord la valeur de n à partir de p et q. Ensuite, elle ouvre le fichier chiffré en lecture, lit les entiers chiffrés un par un à l'aide de la fonction fscanf et les déchiffre à l'aide de l'exponentiation modulaire avec la clé privée. Finalement, elle affiche chaque caractère déchiffré à l'écran.

La fonction void creation_paire_cles : 

Cette fonction génère une paire de clés RSA (une clé publique et une clé privée), en choisissant deux nombres premiers aléatoires p et q. Ensuite, elle calcule n = p * q et phi = (p - 1) * (q - 1). Elle choisit ensuite un entier e aléatoire entre 2 et phi - 1, tel que pgcd(e, phi) = 1. Elle calcule alors l'inverse modulaire d de e modulo phi. Finalement, elle sauvegarde la clé publique dans le fichier fich_cle_pub et la clé privée dans le fichier fich_cle_pri.

La fonction void lecture_cle_pub :

La fonction ouvre le fichier nom_fichier en mode lecture ("r"), vérifie si l'ouverture a réussi et lit les deux entiers représentant la clé publique en utilisant la fonction fscanf. Si la lecture échoue, la fonction affiche un message d'erreur et quitte le programme avec exit(1). Enfin, la fonction ferme le fichier avec fclose.