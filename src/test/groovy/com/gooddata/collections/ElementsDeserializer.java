/*
 * Copyright (C) 2004-2019, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.collections;

import java.util.List;
import java.util.Map;

class ElementsDeserializer extends PageDeserializer<Elements, String> {

    protected ElementsDeserializer() {
        super(String.class);
    }

    @Override
    protected Elements createPage(final List<String> items, final Paging paging, final Map<String, String> links) {
        return new Elements(items, paging, links);
    }
}
