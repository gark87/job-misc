#!/usr/bin/perl

use strict;
use warnings;

my $slide = 1;
my $flag = 0;
while(<>) {
  if (/^%/../^[^%]/) {
    if (s/^%\s*//) {
      unless ($flag) {
        print "========================================\r\n";
        print "Слайд #$slide\r\n";
        print "========================================\r\n\r\n";
        $flag = 1;
        $slide++;
      }
      s/\n/\r\n/;
      print;
    } 
  } else {
    $flag = 0;
  } 
}

