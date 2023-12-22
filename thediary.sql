-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 22, 2023 at 01:27 PM
-- Server version: 5.7.24
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `thediary`
--

-- --------------------------------------------------------

--
-- Table structure for table `diary`
--

CREATE TABLE `diary` (
  `id` int(11) NOT NULL,
  `datetime` datetime(6) DEFAULT NULL,
  `text` text,
  `title` varchar(255) DEFAULT NULL,
  `deleted` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `diary`
--

INSERT INTO `diary` (`id`, `datetime`, `text`, `title`, `deleted`) VALUES
(602, '2023-12-24 15:00:00.000000', 'Nu är det kalle anka hejhej jhihihi', 'Julafton', 0),
(703, '2023-12-18 19:14:00.000000', 'ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff', 'eqweqw', 1),
(704, '2023-12-19 19:49:00.000000', 'testa edit woho hejdå. ', 'Css pill', 0),
(752, '2023-12-19 17:43:00.000000', 'Lade till bakgrundsbild på formet wiho tihihi', 'Bakgrundsbild', 0),
(803, '2023-12-19 18:54:00.000000', 'Nu ska jag kolla hockey hejdå på mig ', 'Hockey', 0),
(804, '2023-12-19 23:25:00.000000', 'Lade till sökfunktion för posts, nästa blir funktion för att kunna visa alla posts och en för att visa aktuella.', 'Sökfunktion', 0),
(852, '2023-12-20 00:58:00.000000', 'toodiloo', 'Godnatt', 0),
(902, '2023-12-20 12:33:00.000000', 'Hej!\r\nIdag är idag om jag visas idag. Bra snack', 'Idag', 1),
(952, '2023-12-20 12:50:00.000000', 'ewqew', 'dd', 1),
(1002, '2023-12-20 13:05:00.000000', 'Nu funkar länk-knapparna för att visa posts. Wohoouii', '\"Knappar\"', 0),
(1003, '2023-12-20 13:06:00.000000', 'Sortera efter datum är ju najs. Bra snack hejdå', 'Sortera', 0),
(1052, '2023-12-20 16:31:00.000000', 'Kaffe är gott', 'Kaffe', 0),
(1102, '2023-12-20 18:50:00.000000', 'öööööööööööööö', 'ööö', 1),
(1104, '2023-12-19 18:43:00.000000', 'Löste formatet på utskrift av posts, testing testing testing testing testing testingtesting testing testingtesting testing testingtesting testing testingtesting testing testingtesting testing testingtesting testing testing flera rader', 'utskrift', 0),
(1105, '2023-12-20 19:11:00.000000', 'Nu funkar edit popupen, nu ska jag bara lista ut varför 1 av 100 inlägg inte går att redigera. blir galennnnnnnnnnnnnnn', 'edit', 0),
(1153, '2023-12-22 10:17:00.000000', 'Idag är idag om inte idag är igår eller imorgon', 'Hejsan', 0),
(1202, '2023-12-22 10:34:00.000000', 'Nu funkar edit post funktionen och den fyller i korrekt. Har ingen aning om varför det inte fungerade på vissa objekt. Men tog bort dessa. Felet kanske blev när jag tidigare hade timestamp på databasen och böt till datetime. Vem vet.. inte jag', 'Funkar', 0),
(1203, '2024-01-01 00:00:00.000000', '2024.. GÖTT!', 'Gott Nytt År', 0),
(1204, '2023-12-22 10:42:00.000000', 'Där får jag nöja mig annars kommer jag sitta och pilla css i all evighet och det är nog inte tanken med uppgiften kan jag tänka mig. :)', 'Nu får det duga', 0),
(1252, '2023-12-22 14:17:00.000000', 'dddeleete', 'ddelete', 1);

-- --------------------------------------------------------

--
-- Table structure for table `diary_seq`
--

CREATE TABLE `diary_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `diary_seq`
--

INSERT INTO `diary_seq` (`next_val`) VALUES
(1351);

-- --------------------------------------------------------

--
-- Table structure for table `thediary`
--

CREATE TABLE `thediary` (
  `id` int(11) NOT NULL,
  `title` varchar(128) DEFAULT NULL,
  `text` varchar(500) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `diary`
--
ALTER TABLE `diary`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `thediary`
--
ALTER TABLE `thediary`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `thediary`
--
ALTER TABLE `thediary`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
