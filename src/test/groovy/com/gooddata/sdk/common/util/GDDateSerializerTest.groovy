/*
 * Copyright (C) 2007-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.sdk.common.util

import org.joda.time.LocalDate
import spock.lang.Specification

import static com.gooddata.sdk.common.util.ResourceUtils.OBJECT_MAPPER

class GDDateSerializerTest extends Specification {

    def "should serialize"() {
        given:
        def date = new GDDateClass(new LocalDate(2012, 3, 20))

        when:
        def json = OBJECT_MAPPER.writeValueAsString(date)
        def node = OBJECT_MAPPER.readTree(json)

        then:
        node.path('date').textValue() == '2012-03-20'
    }

}
