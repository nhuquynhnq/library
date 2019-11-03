-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 03, 2019 at 05:21 AM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qltv`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
CREATE TABLE IF NOT EXISTS `books` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `id_author` int(11) NOT NULL COMMENT 'id của tác giả',
  `id_publisher` int(11) NOT NULL COMMENT 'id của nhà xuất bản',
  `bookname` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'tên sách',
  `publish_year` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'năm xuất bản',
  `description` text COLLATE utf8_unicode_ci COMMENT 'mô tả',
  `page_number` int(11) DEFAULT '0' COMMENT 'số trang',
  `status` tinyint(4) DEFAULT '0' COMMENT 'trạng thái của sách (0 : là chưa có người mượn, 1: có người mượn)',
  `created_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'ngày tạo',
  `updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'ngày cập nhật',
  `image` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `number` int(11) NOT NULL,
  `numberborrow` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `id_author`, `id_publisher`, `bookname`, `publish_year`, `description`, `page_number`, `status`, `created_at`, `updated_at`, `image`, `type`, `number`, `numberborrow`) VALUES
(1, 1, 1, '1001 Bí ẩn', NULL, NULL, 0, 0, '2019-11-03 11:55:01', '2019-11-03 11:55:01', 'images/1001bian.jpg', 'Khoa Học - Kỹ Thuật', 4, 0),
(2, 0, 0, 'Án Mạng Trên Sông Nile', NULL, NULL, 0, 0, '2019-11-03 10:47:46', '2019-11-03 10:47:46', 'images/anmangtrensongnile.jpg', 'Trinh Thám ', 6, 2),
(3, 3, 3, 'Bách Khoa Thư', NULL, NULL, 0, 0, '2019-11-03 11:55:05', '2019-11-03 11:55:05', 'images/bachkhoathu.jpg', 'Khoa Học - Kỹ Thuật', 5, 0),
(4, 4, 4, 'Bàn Về Tinh Thần Pháp Luật', NULL, NULL, 0, 0, '2019-11-03 11:55:13', '2019-11-03 11:55:13', 'images/banvetinhthanpl.jpg', 'Lịch Sử - Chính Trị', 6, 0),
(5, 5, 2, 'Bước Chân Theo Dấu Mặt Trời', NULL, NULL, 0, 0, '2019-10-13 20:55:31', '2019-10-13 20:55:31', 'images/buoctheodaumattroi.jpg', 'Văn Hóa - Tôn Giáo', 9, 0),
(6, 6, 5, 'Chuyến Bay Cuộc Đời', NULL, NULL, 0, 0, '2019-10-13 20:55:36', '2019-10-13 20:55:36', 'images/chuyenbaycuocdoi.jpg', 'Tâm Lý - Kỹ Năng Sống', 3, 0),
(7, 7, 3, 'Chuyên Ngành Cơ Khí', NULL, NULL, 0, 0, '2019-11-03 11:54:13', '2019-11-03 11:54:13', 'images/chuyennganhcokhi.jpg', 'Khoa Học - Kỹ Thuật', 7, 3),
(8, 8, 6, 'Code Dạo Ký Sự', NULL, NULL, 0, 0, '2019-10-13 20:55:45', '2019-10-13 20:55:45', 'images/codedaokisu.jpg', 'Khoa Học - Kỹ Thuật', 10, 0),
(9, 9, 4, 'Cô Gái Có Hình Xăm Rồng', NULL, NULL, 0, 0, '2019-10-13 20:55:49', '2019-10-13 20:55:49', 'images/cogaicohinhxamrong.jpg', 'Trinh Thám - Hình Sự', 11, 0),
(10, 10, 2, 'Con Tằm', NULL, NULL, 0, 0, '2019-10-13 20:55:55', '2019-10-13 20:55:55', 'images/contam.jpg', 'Trinh Thám - Hình Sự', 12, 0),
(11, 11, 3, 'Điệp Viên Kỳ Quái', NULL, NULL, 0, 0, '2019-10-13 20:55:59', '2019-10-13 20:55:59', 'images/diepvienkiquai.jpg', 'Trinh Thám - Hình Sự', 5, 0),
(12, 12, 7, 'Đi Vào Nghiên Cứu Khoa Học', NULL, NULL, 0, 0, '2019-10-13 20:56:03', '2019-10-13 20:56:03', 'images/divaonghiencuukh.jpg', 'Khoa Học - Kỹ Thuật', 7, 0),
(13, 13, 2, 'Đọc Vị Bất Kì Ai', NULL, NULL, 0, 0, '2019-10-13 20:56:06', '2019-10-13 20:56:06', 'images/docvibatkiai.jpg', 'Tâm Lý - Kỹ Năng Sống', 9, 0),
(14, 14, 8, 'Đông Kinh Nghĩa Thục', NULL, NULL, 0, 0, '2019-10-13 20:56:10', '2019-10-13 20:56:10', 'images/dongkinhnghiathuc.jpg', 'Văn Hóa - Tôn Giáo', 2, 0),
(15, 15, 9, 'Kỹ Thuật Lập Trình', NULL, NULL, 0, 0, '2019-10-13 20:56:14', '2019-10-13 20:56:14', 'images/kythuatlaptrinh.jpg', 'Khoa Học - Kỹ Thuật', 3, 0),
(16, 16, 8, 'Làng Xóm Việt Nam', NULL, NULL, 0, 0, '2019-10-13 20:56:18', '2019-10-13 20:56:18', 'images/langxomvn.jpg', 'Văn Hóa - Tôn Giáo', 4, 0),
(17, 17, 10, 'Giáo Trình Lịch Sử Đảng Cộng Sản Việt Nam', NULL, NULL, 0, 0, '2019-10-13 20:56:23', '2019-10-13 20:56:23', 'images/lichsudang.jpg', 'Lịch Sử - Chính Trị', 5, 0),
(19, 19, 8, 'Lịch Sử Triết Học', NULL, NULL, 0, 0, '2019-10-13 20:56:26', '2019-10-13 20:56:26', 'images/lichsutriethoc.jpg', 'Lịch Sử - Chính Trị', 7, 0),
(20, 20, 2, 'Lửa Hận', NULL, NULL, 0, 0, '2019-10-13 20:56:29', '2019-10-13 20:56:29', 'images/luahan.jpg', 'Trinh Thám - Hình Sự', 8, 0),
(21, 21, 8, 'Mật Mã Davici', NULL, NULL, 0, 0, '2019-10-13 20:56:33', '2019-10-13 20:56:33', 'images/matmadavici.jpg', 'Trinh Thám - Hình Sự', 9, 0),
(22, 22, 8, 'Nguồn Gốc Văn Hóa Việt Nam', NULL, NULL, 0, 0, '2019-10-13 20:56:38', '2019-10-13 20:56:38', 'images/nguongocvanhoavn.jpg', 'Văn Hóa - Tôn Giáo', 10, 0),
(23, 23, 8, 'Nho Giáo Trung Quốc', NULL, NULL, 0, 0, '2019-10-13 20:56:41', '2019-10-13 20:56:41', 'images/nhogiaotq.jpg', 'Văn Hóa - Tôn Giáo', 11, 0),
(24, 24, 7, 'Phật Giáo Hòa Hảo', NULL, NULL, 0, 0, '2019-10-13 20:56:43', '2019-10-13 20:56:43', 'images/phatgiaohoahao.jpg', 'Văn Hóa - Tôn Giáo', 12, 0),
(25, 25, 11, 'Chính Trị Thế Giới Sau Năm 1945', NULL, NULL, 0, 0, '2019-10-13 20:56:46', '2019-10-13 20:56:46', 'images/sach-chinh-tri-the-gioi-sau-nam-1945.jpg', 'Lịch Sử - Chính Trị', 12, 0),
(26, 26, 2, 'SherlockHomes', NULL, NULL, 0, 0, '2019-10-13 20:56:50', '2019-10-13 20:56:50', 'images/Sherlockhome.jpg', 'Trinh Thám - Hình Sự', 13, 0),
(27, 27, 2, 'Sự Im Lặng Của Bầy Cừu', NULL, NULL, 0, 0, '2019-10-13 21:16:29', '2019-10-13 21:16:29', 'images/suimlangcuabaycuu.jpg', 'Trinh Thám - Hình Sự', 14, 0),
(28, 28, 2, 'Tâm Lý Học Đám Đông', NULL, NULL, 0, 0, '2019-10-13 21:16:31', '2019-10-13 21:16:31', 'images/tamlyhocdamdong.jpg', 'Tâm Lý - Kỹ Năng Sống', 15, 0),
(29, 29, 2, 'Tâm Thức Isreal', NULL, NULL, 0, 0, '2019-10-13 21:16:34', '2019-10-13 21:16:34', 'images/tamthucistreal.jpg', 'Tâm Lý - Kỹ Năng Sống', 16, 0),
(30, 30, 8, 'Triết Học Kì Thú', NULL, NULL, 0, 0, '2019-10-13 21:16:37', '2019-10-13 21:16:37', 'images/thkithu.jpg', 'Triết Học', 2, 0),
(31, 31, 12, 'Triết Học Luật Pháp', NULL, NULL, 0, 0, '2019-10-13 21:16:41', '2019-10-13 21:16:41', 'images/thluatphap.jpg', 'Triết Học', 3, 0),
(32, 32, 10, 'Giáo Trình Triết Học Mác Lê-nin', NULL, NULL, 0, 0, '2019-10-13 21:16:46', '2019-10-13 21:16:46', 'images/thmac.jpg', 'Triết Học', 4, 0),
(33, 33, 3, 'Triết Sử Ấn Độ', NULL, NULL, 0, 0, '2019-10-13 21:16:51', '2019-10-13 21:16:51', 'images/thando.jpg', 'Triết Học', 5, 0),
(34, 34, 2, 'Tôi Tự Học', NULL, NULL, 0, 0, '2019-10-13 21:16:53', '2019-10-13 21:16:53', 'images/toituhoc.jpg', 'Tâm Lý - Kỹ Năng Sống', 4, 0),
(35, 35, 2, 'Bên Nhau Trọn Đời', NULL, NULL, 0, 0, '2019-10-13 21:17:00', '2019-10-13 21:17:00', 'images/ttbennhautrondoi.jpg', 'Tiểu Thuyết', 4, 0),
(36, 36, 2, 'Chúa Tể Những Chiếc Nhẫn', NULL, NULL, 0, 0, '2019-10-13 21:17:07', '2019-10-13 21:17:07', 'images/ttchuatenhungchiecnhan.jpg', 'Tiểu Thuyết', 3, 0),
(37, 37, 2, 'Lâu Đài Cát', NULL, NULL, 0, 0, '2019-10-13 21:17:12', '2019-10-13 21:17:12', 'images/ttlaudaicat.jpg', 'Tiểu Thuyết', 2, 0),
(38, 38, 13, 'Miền Trần Gian', NULL, NULL, 0, 0, '2019-10-13 21:17:16', '2019-10-13 21:17:16', 'images/ttmientrangian.jpg', 'Tiểu Thuyết', 1, 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
