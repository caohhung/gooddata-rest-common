/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.sdk.common.util

import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import spock.lang.Specification
import spock.lang.Unroll

import static com.gooddata.sdk.common.util.ResourceUtils.OBJECT_MAPPER

class GDDateTimeSerializerTest extends Specification {

    @Unroll
    def "should serialize for zone #dateTimeZone"() {
        given:
        def dateTime = new GDDateTimeClass(new DateTime(2012, 3, 20, 14, 31, 5, 3, dateTimeZone))

        when:
        def json = OBJECT_MAPPER.writeValueAsString(dateTime)
        def node = OBJECT_MAPPER.readTree(json)

        then:
        node.path('date').textValue() == expectedDateTime

        where:
        dateTimeZone | expectedDateTime
        DateTimeZone.UTC | '2012-03-20 14:31:05'
        DateTimeZone.forID("Europe/Prague") | '2012-03-20 13:31:05'
    }

    def "should serialize null"() {
        given:
        def dateTime = new GDDateTimeClass(null)

        when:
        def json = OBJECT_MAPPER.writeValueAsString(dateTime)
        def node = OBJECT_MAPPER.readTree(json)

        then:
        node.path('date').isNull()
    }
}
