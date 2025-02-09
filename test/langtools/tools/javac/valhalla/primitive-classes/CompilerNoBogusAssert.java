/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * @test
 * @bug 8222711
 * @summary Regression test for bogus assertion failure.
 * @compile -XDenablePrimitiveClasses CompilerNoBogusAssert.java
 * @run main/othervm -XX:+EnableValhalla -XX:+EnablePrimitiveClasses CompilerNoBogusAssert
 */

public class CompilerNoBogusAssert {

    static primitive class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static void testCastingFromBoxToVal(Point.ref p) {
        boolean npe = false;
        try {
            Point pv = (Point) p;
        } catch(NullPointerException e) {
            npe = true;
        }
        if (npe) {
        } else {
        }
    }

    public static void main(String[] args) {
        testCastingFromBoxToVal(new Point(3,4));
    }
}
