-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 19 juin 2020 à 12:15
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `huntkingdom`
--

-- --------------------------------------------------------

--
-- Structure de la table `animals`
--

DROP TABLE IF EXISTS `animals`;
CREATE TABLE IF NOT EXISTS `animals` (
  `nom` varchar(20) DEFAULT NULL,
  `race` varchar(20) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `animals`
--

INSERT INTO `animals` (`nom`, `race`, `id`, `image_name`) VALUES
('chat', 'kalb', 22, '92155158_2790347487729453_4483019046031196160_n.jpg'),
('chat', 'kalb', 24, 'PngItem_5074322.png');

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

DROP TABLE IF EXISTS `annonce`;
CREATE TABLE IF NOT EXISTS `annonce` (
  `id_annonce` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `aime` int(11) DEFAULT NULL,
  `etat` int(100) NOT NULL,
  PRIMARY KEY (`id_annonce`),
  KEY `annonce_ibfk_1` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `annonce`
--

INSERT INTO `annonce` (`id_annonce`, `text`, `image`, `user_id`, `aime`, `etat`) VALUES
(35, 'a', 'pBD8.jpg', 14, 0, 0),
(38, 'Ecrivez ', 'p818.jpg', 14, 0, 0),
(39, 'test ', 'pF54.jpg', 14, 0, 0),
(40, 'Ecrivez ', 'pB7B.jpg', 14, 0, 0),
(43, 'aze ', 'p548.jpg', 14, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `chasse`
--

DROP TABLE IF EXISTS `chasse`;
CREATE TABLE IF NOT EXISTS `chasse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `animal` int(11) NOT NULL,
  `region` varchar(20) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `type` varchar(255) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `idp` int(11) DEFAULT NULL,
  `etat` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idp` (`idp`),
  KEY `id_user` (`id_user`),
  KEY `animal` (`animal`)
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `chasse`
--

INSERT INTO `chasse` (`id`, `animal`, `region`, `date_debut`, `date_fin`, `type`, `id_user`, `idp`, `etat`) VALUES
(216, 24, 'Bizerte', '2020-04-26', '2020-05-29', 'herbivore', 9, NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `idcmd` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prix_total` int(11) NOT NULL,
  `etat` varchar(255) NOT NULL,
  PRIMARY KEY (`idcmd`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`idcmd`, `id`, `quantite`, `prix_total`, `etat`) VALUES
(3, 3, 2, 24, 'en cours '),
(5, 13, 3, 450, 'traitée'),
(6, 13, 6, 483, 'traitée'),
(7, 13, 7, 71, 'en cours '),
(8, 13, 8, 82, 'en cours ');

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `id_commentaire` int(100) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `id_annonce` int(11) DEFAULT NULL,
  `commentaire` varchar(255) NOT NULL,
  PRIMARY KEY (`id_commentaire`),
  KEY `id_user` (`id_user`),
  KEY `id_annonce` (`id_annonce`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id_commentaire`, `id_user`, `id_annonce`, `commentaire`) VALUES
(13, 13, 17, 'test comment'),
(15, 13, 15, 'test comment');

-- --------------------------------------------------------

--
-- Structure de la table `demande_admin`
--

DROP TABLE IF EXISTS `demande_admin`;
CREATE TABLE IF NOT EXISTS `demande_admin` (
  `id_demande` int(100) NOT NULL AUTO_INCREMENT,
  `id_user` int(100) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  PRIMARY KEY (`id_demande`),
  KEY `id_user` (`id_user`),
  KEY `nom` (`nom`),
  KEY `prenom` (`prenom`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `id_event` int(11) NOT NULL AUTO_INCREMENT,
  `titre_event` varchar(50) NOT NULL,
  `description_event` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `date_debut_event` date NOT NULL,
  `date_fin_event` date NOT NULL,
  `nb_place_event` int(11) NOT NULL,
  `nb` int(11) NOT NULL,
  `idUser` int(11) DEFAULT NULL,
  `$idUserr` int(11) NOT NULL,
  `etat` int(11) NOT NULL,
  PRIMARY KEY (`id_event`),
  KEY `IDX_B26681EFE6E88D7` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id_event`, `titre_event`, `description_event`, `image`, `date_debut_event`, `date_fin_event`, `nb_place_event`, `nb`, `idUser`, `$idUserr`, `etat`) VALUES
(118, 'hunt', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor i', '99a730e723fef953ab742921efa2fd98.png', '2020-05-21', '2020-05-23', 20, 20, NULL, 0, 1),
(119, 'hun', 'hdbjhjh', '99a730e723fef953ab742921efa2fd98.png', '2026-06-20', '2026-06-20', 30, 30, NULL, 16, 1);

-- --------------------------------------------------------

--
-- Structure de la table `events`
--

DROP TABLE IF EXISTS `events`;
CREATE TABLE IF NOT EXISTS `events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `start_event` datetime NOT NULL,
  `end_event` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `events`
--

INSERT INTO `events` (`id`, `title`, `start_event`, `end_event`) VALUES
(1, 'hello', '2020-03-23 00:00:00', '2020-03-31 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `newsletter`
--

DROP TABLE IF EXISTS `newsletter`;
CREATE TABLE IF NOT EXISTS `newsletter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `etat` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `newsletter`
--

INSERT INTO `newsletter` (`id`, `id_user`, `mail`, `etat`) VALUES
(11, 9, 'walid.tayeche@esprit.tn', 1),
(12, 12, 'belkis.baccar@esprit.tn', 1);

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

DROP TABLE IF EXISTS `panier`;
CREATE TABLE IF NOT EXISTS `panier` (
  `idp` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `nomP` varchar(255) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prix` int(11) NOT NULL,
  PRIMARY KEY (`idp`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `panier`
--

INSERT INTO `panier` (`idp`, `id`, `nomP`, `quantite`, `prix`) VALUES
(8, 13, 'tent', 1, 5),
(7, 13, 'gjlk', 7, 77);

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

DROP TABLE IF EXISTS `participation`;
CREATE TABLE IF NOT EXISTS `participation` (
  `id_participation` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `id_event` int(11) DEFAULT NULL,
  `date_reservation` date NOT NULL,
  PRIMARY KEY (`id_participation`),
  KEY `username` (`username`),
  KEY `id_event` (`id_event`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prix` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  `prix_promo` float NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`ID`, `nom`, `quantite`, `prix`, `image`, `prix_promo`) VALUES
(21, 'prod1', 150, 80, '16056d667871195e9a9dbcf4cab60fcb.jpeg', 20),
(23, 'ikol', 150, 20, 'a3f0f07383fa7f458f41ed2916423f74.png', 0);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `id_promotion` int(11) NOT NULL AUTO_INCREMENT,
  `id_produit` int(11) DEFAULT NULL,
  `taux` float NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `etat` int(11) NOT NULL,
  PRIMARY KEY (`id_promotion`),
  KEY `IDX_C11D7DD1F7384557` (`id_produit`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `publicite`
--

DROP TABLE IF EXISTS `publicite`;
CREATE TABLE IF NOT EXISTS `publicite` (
  `id_publicite` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `date_debut` datetime NOT NULL,
  `date_fin` datetime NOT NULL,
  `nom_proprietaire` varchar(25) NOT NULL,
  `prix` float NOT NULL,
  `position` int(11) NOT NULL,
  `etat` int(11) NOT NULL,
  `nb_like` int(11) NOT NULL,
  PRIMARY KEY (`id_publicite`)
) ENGINE=InnoDB AUTO_INCREMENT=272 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `publicite`
--

INSERT INTO `publicite` (`id_publicite`, `nom`, `image`, `date_debut`, `date_fin`, `nom_proprietaire`, `prix`, `position`, `etat`, `nb_like`) VALUES
(270, 'walid23', '92155158_2790347487729453_4483019046031196160_n.jpg', '2020-04-26 22:02:00', '2020-05-02 22:02:00', '89', 150, 1, 1, 5),
(271, 'hello', 'y2mate.com - Skechers Men’s Boots commercial_fb5ICoamIWs_1080p.mp4', '2020-04-26 22:02:00', '2020-05-22 00:00:00', 'walid', 150, 3, 1, 8);

-- --------------------------------------------------------

--
-- Structure de la table `publicite_aimer`
--

DROP TABLE IF EXISTS `publicite_aimer`;
CREATE TABLE IF NOT EXISTS `publicite_aimer` (
  `id_pub_aimer` int(11) NOT NULL AUTO_INCREMENT,
  `id_publicite` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_pub_aimer`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `id_reclamation` int(10) NOT NULL AUTO_INCREMENT,
  `etat` varchar(25) NOT NULL,
  `description` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `note` int(1) NOT NULL,
  `id_annonce_reclame` int(11) DEFAULT NULL,
  `id_user` int(10) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `id_produit` int(11) DEFAULT NULL,
  `priority` int(1) NOT NULL,
  PRIMARY KEY (`id_reclamation`),
  KEY `id_produit` (`id_produit`),
  KEY `id_annonce_reclame` (`id_annonce_reclame`) USING BTREE,
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reclamation`
--

INSERT INTO `reclamation` (`id_reclamation`, `etat`, `description`, `image`, `note`, `id_annonce_reclame`, `id_user`, `date`, `id_produit`, `priority`) VALUES
(144, 'Non traitée', 'Description de la réclamation', 'p847.jpg', 0, NULL, 14, '2020-06-12', 21, 0),
(145, 'Non traitée', 'Description de la réclamation', 'p584.jpg', 0, NULL, 14, '2020-06-12', 21, 3),
(146, 'Non traitée', 'test ', 'p9B3.jpg', 3, NULL, 14, '2020-06-19', 21, 0),
(147, 'Non traitée', 'test réclamation', 'p7FB.jpg', 0, NULL, 14, '2020-06-19', 23, 0);

-- --------------------------------------------------------

--
-- Structure de la table `reponse`
--

DROP TABLE IF EXISTS `reponse`;
CREATE TABLE IF NOT EXISTS `reponse` (
  `id_reponse` int(10) NOT NULL AUTO_INCREMENT,
  `id_reclamation` int(11) DEFAULT NULL,
  `contenu` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_reponse`),
  KEY `id_reclamation` (`id_reclamation`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reponse`
--

INSERT INTO `reponse` (`id_reponse`, `id_reclamation`, `contenu`, `image`, `date`) VALUES
(35, 146, 'votre réclamation est en traitement', 'téléchargement.png', '2020-06-19');

-- --------------------------------------------------------

--
-- Structure de la table `tab`
--

DROP TABLE IF EXISTS `tab`;
CREATE TABLE IF NOT EXISTS `tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  `photo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_8D93D64992FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_8D93D649A0D96FBF` (`email_canonical`),
  UNIQUE KEY `UNIQ_8D93D649C05FB297` (`confirmation_token`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `photo`) VALUES
(9, 'helo', 'helo', 'walid17@hotmail.com', 'walid17@hotmail.com', 1, NULL, '$2y$13$ijxtBinqyu77cicEB1Tv4OeYD1jBz3CNUm9yn13Ob1Mpkr.SXS8P6', '2020-04-19 13:06:58', NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_CLIENT\";}', 'logo-decathlon.jpg'),
(10, 'walid25', 'walid25', 'walid23@hotmail.com', 'walid23@hotmail.com', 1, NULL, '$2y$13$xuyd0KO7jpaafnfcN32H3euVC.b3sYP7yHQet9NSm4WoGKDAB1n4.', '2020-04-19 13:09:53', NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_AGENT\";}', '78402023_488679891997780_148884723488260096_n.jpg'),
(11, 'walidtayeche', 'walidtayeche', 'belkis@hotmail.com', 'belkis@hotmail.com', 1, NULL, '$2y$13$CTpQ.PgB.FjgeMJpd6xk3uslH5PfJbiIULP.8uPJljE9Mroat/CkC', '2020-04-17 23:17:52', NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_AGENT\";}', 'black-cannabis-graphic-png-clip-art.png'),
(13, 'belkidsa', 'belkidsa', 'belki1111s.baccar@esprit.tn', 'belki1111s.baccar@esprit.tn', 1, NULL, '$2y$13$QvVdrICRhr81HBhU1KKZ/.7M9N9BWGMCZqMAG6ehkpYFfq3uHOoKG', '2020-06-19 08:52:33', NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_AGENT\";}', 'Belkis Baccar.jpg'),
(14, 'belkisc', 'belkisc', 'belkis.baccar@esprit.tn', 'belkis.baccar@esprit.tn', 1, NULL, '$2y$13$ChApbvZ9o98egUKqSpBmOusGbj/.cqWqyKV89j1NMKsFwdcV8Tls6', '2020-06-12 18:37:33', NULL, NULL, 'a:1:{i:0;s:11:\"ROLE_CLIENT\";}', 'Belkis Baccar.jpg');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `chasse`
--
ALTER TABLE `chasse`
  ADD CONSTRAINT `chasse_ibfk_1` FOREIGN KEY (`animal`) REFERENCES `animals` (`id`);

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `FK_B26681EFE6E88D7` FOREIGN KEY (`idUser`) REFERENCES `user` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `FK_AB55E24FD52B4B97` FOREIGN KEY (`id_event`) REFERENCES `evenement` (`id_event`);

--
-- Contraintes pour la table `promotion`
--
ALTER TABLE `promotion`
  ADD CONSTRAINT `FK_C11D7DD1F7384557` FOREIGN KEY (`id_produit`) REFERENCES `product` (`ID`);

--
-- Contraintes pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD CONSTRAINT `reponse_ibfk_1` FOREIGN KEY (`id_reclamation`) REFERENCES `reclamation` (`id_reclamation`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
