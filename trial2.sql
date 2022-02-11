-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 08, 2022 at 11:28 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trial2`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Admin_Email` varchar(255) CHARACTER SET utf16 NOT NULL,
  `Admin_password` varchar(255) CHARACTER SET utf16 NOT NULL,
  `Admin_name` varchar(255) CHARACTER SET utf16 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Admin_Email`, `Admin_password`, `Admin_name`) VALUES
('Hossam@admin.com', 'hossam123', 'hossam'),
('seif@admin.com', 'seif123', 'seif'),
('ziad@admin.com', '1234', 'Ziad Hesham');

-- --------------------------------------------------------

--
-- Table structure for table `admin_log`
--

CREATE TABLE `admin_log` (
  `Log_ID` int(10) NOT NULL,
  `Admin_Email` varchar(255) CHARACTER SET utf16 NOT NULL,
  `Date` varchar(255) CHARACTER SET utf16 NOT NULL,
  `Time` varchar(255) CHARACTER SET utf32 NOT NULL,
  `Edited_visitor_ID` int(10) NOT NULL,
  `Edited_Event_ID` int(10) NOT NULL,
  `Edited_Monument_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_log`
--

INSERT INTO `admin_log` (`Log_ID`, `Admin_Email`, `Date`, `Time`, `Edited_visitor_ID`, `Edited_Event_ID`, `Edited_Monument_ID`) VALUES
(4, 'ziad@admin.com\r\n', 'dd/mm/yyyy', '**:**', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `book an event`
--

CREATE TABLE `book an event` (
  `VisitorID` int(10) NOT NULL,
  `EventsID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book an event`
--

INSERT INTO `book an event` (`VisitorID`, `EventsID`) VALUES
(13, 1),
(14, 3),
(15, 1),
(15, 2);

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `ID` int(10) NOT NULL,
  `Event Name` varchar(255) DEFAULT NULL,
  `Event_start_time` varchar(15) CHARACTER SET utf16 DEFAULT NULL,
  `Event_end_time` varchar(15) CHARACTER SET utf16 DEFAULT NULL,
  `Event_description` varchar(1000) DEFAULT NULL,
  `Event_Date` varchar(15) CHARACTER SET utf16 DEFAULT NULL,
  `URL` varchar(255) CHARACTER SET utf16 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`ID`, `Event Name`, `Event_start_time`, `Event_end_time`, `Event_description`, `Event_Date`, `URL`) VALUES
(1, 'ziad day', '5:00 PM', '7:00 PM', 'Evant meya al meya w gameed', '22/1/2022', '/GUI/Icons/Event Description/Bitmap.png'),
(2, 'hossam day', '3:00 PM', '7:00 PM', 'event gameeeed', '12/1/2022', '/GUI/Icons/Event Description/Bitmap.png'),
(3, 'Seif day', '3:00 PM', '7:00 PM', 'event gameeeed', '12/1/2022', '/GUI/Icons/Event Description/Bitmap.png');

-- --------------------------------------------------------

--
-- Table structure for table `monuments`
--

CREATE TABLE `monuments` (
  `ID` int(10) NOT NULL,
  `Name` varchar(20) CHARACTER SET utf16 NOT NULL,
  `Barcode` int(10) NOT NULL,
  `Breif` varchar(1000) DEFAULT NULL,
  `Tag` int(10) NOT NULL,
  `URL` varchar(255) CHARACTER SET utf16 NOT NULL,
  `occupied_by_EventID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `monuments`
--

INSERT INTO `monuments` (`ID`, `Name`, `Barcode`, `Breif`, `Tag`, `URL`, `occupied_by_EventID`) VALUES
(1, 'Ramses II', 1520, 'Brief-Brief2-Brief3-Brief4-Brief5', 0, '/Icons/folder/Monument.png', NULL),
(9, 'King Tut', 7373, 'Brief-Brief2-Brief3-Brief4', 0, '/Icons/folder/RectangleKingTut.png', NULL),
(10, 'King Tut', 3737, 'Brief-Brief2-Brief3-Brief4', 0, '/Icons/folder/RectangleKingTut.png', NULL),
(11, 'Ramses II', 1521, 'Brief-Brief2-Brief3-Brief4', 0, '/Icons/folder/Monument.png', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `ID` int(10) NOT NULL,
  `price` int(10) DEFAULT NULL,
  `date` varchar(15) CHARACTER SET utf16 COLLATE utf16_estonian_ci DEFAULT NULL,
  `Visitor_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`ID`, `price`, `date`, `Visitor_ID`) VALUES
(1, 50, '10/12/2222', 13),
(3, 250, '10/12/2222', 7777),
(6, 900, '3-12-2022', 15),
(10, 900, '683/62516', 14);

-- --------------------------------------------------------

--
-- Table structure for table `visitor`
--

CREATE TABLE `visitor` (
  `ID` int(10) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `National_ID` varchar(14) CHARACTER SET utf16 NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `phone number` varchar(13) CHARACTER SET utf16 DEFAULT NULL,
  `Age` int(10) DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `visitor`
--

INSERT INTO `visitor` (`ID`, `Email`, `Password`, `National_ID`, `Name`, `phone number`, `Age`, `Gender`, `Status`) VALUES
(13, 'ziadf@abc.com', 'ziad123', '29910012135', 'Ziad', '01110409971', 21, 'Male', 'Egyptian'),
(14, 'seif@abc.com', '12345seif', '5556447855', 'seif', '01542354', 66, 'Male', 'Egyptian'),
(15, 'SeifMostafa7347@gmail.com', 'Seif123', '2250128511', 'SeifMostafa', '01023595588', 12, 'Male', 'Student');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Admin_Email`),
  ADD UNIQUE KEY `Admin_password` (`Admin_password`);

--
-- Indexes for table `admin_log`
--
ALTER TABLE `admin_log`
  ADD PRIMARY KEY (`Log_ID`);

--
-- Indexes for table `book an event`
--
ALTER TABLE `book an event`
  ADD KEY `VisitorID` (`VisitorID`,`EventsID`) USING BTREE;

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `monuments`
--
ALTER TABLE `monuments`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Barcode` (`Barcode`),
  ADD UNIQUE KEY `occupied_by_EventID` (`occupied_by_EventID`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Visitor_ID` (`Visitor_ID`);

--
-- Indexes for table `visitor`
--
ALTER TABLE `visitor`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `Password` (`Password`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_log`
--
ALTER TABLE `admin_log`
  MODIFY `Log_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `monuments`
--
ALTER TABLE `monuments`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `visitor`
--
ALTER TABLE `visitor`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book an event`
--
ALTER TABLE `book an event`
  ADD CONSTRAINT `FKBook an Ev162552` FOREIGN KEY (`VisitorID`) REFERENCES `visitor` (`ID`),
  ADD CONSTRAINT `FKBook an Ev836252` FOREIGN KEY (`EventsID`) REFERENCES `events` (`ID`);

--
-- Constraints for table `monuments`
--
ALTER TABLE `monuments`
  ADD CONSTRAINT `occupied monuments` FOREIGN KEY (`occupied_by_EventID`) REFERENCES `events` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
