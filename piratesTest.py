'''
@author: roberto.flores
'''
import unittest
import pirates

class Test(unittest.TestCase):

    def test00(self):
        actual   = pirates.process( 0, [ 
                ( 'Q', 10000 ),
                ( 'S',  9000 ),
        ] )
        expected = 'Q:10000 S:9000'
        self.assertEqual( expected, actual )

    def test01(self):
        actual   = pirates.process( 1, [ 
                ( 'ruby',    6000, 5000 ),
                ( 'diamond', 5000, 4000 ),
        ] )
        expected = "ruby:6000 diamond:4000"
        self.assertEqual( expected, actual )

    def test02(self):
        actual   = pirates.process( 5, [ 
                ( 'Z', 10000, 9000, 8000, 7000, 7000, 7000 ),
                ( 'Y',  9000, 8000, 7000, 6000, 5000, 4000 ),
        ] )
        expected = "Z:10000 Y:4000"
        self.assertEqual( expected, actual )

    def test03(self):
        actual   = pirates.process( 5, [ 
                ( 'Z', 100, 90, 80, 70, 60, 40 ),
                ( 'Y',  90, 80, 70, 60, 50, 40 ),
        ] )
        expected = "Z:100 Z:40"
        self.assertEqual( expected, actual )

    def test04(self):
        actual   = pirates.process( 3, [ 
                ( 'Sapphire',  500,  500,   50,   50 ),
                ( 'Ruby',     5000,  500,   50,    5 ),
                ( 'Zircon',      1,    0,    0,    0 ),
                ( 'Diamond', 10000, 9000, 8000, 6000 ),
        ] )
        expected = "Ruby:5000 Ruby:5"
        self.assertEqual( expected, actual )

    def test05(self):
        actual   = pirates.process( 3, [ 
                ( 'A', 100, 100, 100, 100 ),
                ( 'B', 100, 100, 100, 100 ),
                ( 'C', 100, 100, 100, 100 ),
                ( 'D', 101, 100, 100, 100 ),
        ] )
        expected = "A:100 C:100"
        self.assertEqual( expected, actual )

    def test06(self):
        actual   = pirates.process( 2, [ 
                ( 'A',  100, 100, 100, 100 ),
                ( 'B',  950, 950, 950, 100 ),
                ( 'C',  100, 100, 100, 100 ),
                ( 'D', 1000, 900, 900, 900 ),
        ] )
        expected = "D:900 A:100"
        self.assertEqual( expected, actual )

    def test07(self):
        actual   = pirates.process( 4, [ 
                ( 'A',  100, 100, 100, 100 ),
                ( 'B',  950, 950, 950, 950 ),
                ( 'C',  100, 100, 100, 100 ),
                ( 'D', 1000, 900, 900, 900 ),
        ] )
        expected = "B:950 C:100"
        self.assertEqual( expected, actual )

    def test08(self):
        actual   = pirates.process( 10, [ 
                ( 'L', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'M', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'N', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'O', 15, 12, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'P', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'Q', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'R', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'S', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'T', 15, 12, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'U', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'V', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'W', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'X', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'Y', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'Z', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'A', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'B', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'C', 15, 12, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'D', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'E', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'F', 15, 12, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'G', 10,  9 ,8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'H', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'I', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'J', 15, 12, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
                ( 'K', 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 1 ),
        ] )
        expected = "C:5 X:5"
        self.assertEqual( expected, actual )

    def test09(self):
        actual   = pirates.process( 100, [ 
                ( 'L', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'M', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'N', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'O', 15, 12,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'P', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'Q', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'R', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'S', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'T', 15, 12,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'U', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'V', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'W', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'X', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'Y', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'Z', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'A', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'B', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'C', 15, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12 ),
                ( 'D', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'E', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'F', 15, 12,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'G', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'H', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'I', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'J', 15, 12,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
                ( 'K', 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  1 ),
        ] )
        expected = "D:9 E:1"
        self.assertEqual( expected, actual )

if __name__ == "__main__":
    unittest.main()

