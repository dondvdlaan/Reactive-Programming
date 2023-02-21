-- Creation of test database for reactive patterns

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `reactive`
--
CREATE DATABASE IF NOT EXISTS `reactive` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `reactive`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `empID` int(11) NOT NULL,
  `empFirstName` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `empLastName` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Indizes für die Tabelle `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`empID`);

--
-- AUTO_INCREMENT für Tabelle `employees`
--
ALTER TABLE `employees`
  MODIFY `empID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Fill table `employees` with data
--
LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;

INSERT INTO `employees` (empFirstName, empLastName) VALUES ('Mickey', 'Mouse');
INSERT INTO `employees` (empFirstName, empLastName) VALUES ('Mickey2', 'Mouse2');
INSERT INTO `employees` (empFirstName, empLastName) VALUES ('Mickey3', 'Mouse3');
INSERT INTO `employees` (empFirstName, empLastName) VALUES ('Mickey4', 'Mouse4');
INSERT INTO `employees` (empFirstName, empLastName) VALUES ('Mickey5', 'Mouse5');

/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;


COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
