/*
 * Copyright 2011-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.ec2.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.ec2.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;

/**
 * GetReservedInstancesExchangeQuoteRequest Marshaller
 */

public class GetReservedInstancesExchangeQuoteRequestMarshaller implements
        Marshaller<Request<GetReservedInstancesExchangeQuoteRequest>, GetReservedInstancesExchangeQuoteRequest> {

    public Request<GetReservedInstancesExchangeQuoteRequest> marshall(GetReservedInstancesExchangeQuoteRequest getReservedInstancesExchangeQuoteRequest) {

        if (getReservedInstancesExchangeQuoteRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<GetReservedInstancesExchangeQuoteRequest> request = new DefaultRequest<GetReservedInstancesExchangeQuoteRequest>(
                getReservedInstancesExchangeQuoteRequest, "AmazonEC2");
        request.addParameter("Action", "GetReservedInstancesExchangeQuote");
        request.addParameter("Version", "2016-09-15");
        request.setHttpMethod(HttpMethodName.POST);

        com.amazonaws.internal.SdkInternalList<String> reservedInstanceIdsList = (com.amazonaws.internal.SdkInternalList<String>) getReservedInstancesExchangeQuoteRequest
                .getReservedInstanceIds();
        if (!reservedInstanceIdsList.isEmpty() || !reservedInstanceIdsList.isAutoConstruct()) {
            int reservedInstanceIdsListIndex = 1;

            for (String reservedInstanceIdsListValue : reservedInstanceIdsList) {
                if (reservedInstanceIdsListValue != null) {
                    request.addParameter("ReservedInstanceId." + reservedInstanceIdsListIndex, StringUtils.fromString(reservedInstanceIdsListValue));
                }
                reservedInstanceIdsListIndex++;
            }
        }

        com.amazonaws.internal.SdkInternalList<TargetConfigurationRequest> targetConfigurationsList = (com.amazonaws.internal.SdkInternalList<TargetConfigurationRequest>) getReservedInstancesExchangeQuoteRequest
                .getTargetConfigurations();
        if (!targetConfigurationsList.isEmpty() || !targetConfigurationsList.isAutoConstruct()) {
            int targetConfigurationsListIndex = 1;

            for (TargetConfigurationRequest targetConfigurationsListValue : targetConfigurationsList) {

                if (targetConfigurationsListValue.getOfferingId() != null) {
                    request.addParameter("TargetConfiguration." + targetConfigurationsListIndex + ".OfferingId",
                            StringUtils.fromString(targetConfigurationsListValue.getOfferingId()));
                }

                if (targetConfigurationsListValue.getInstanceCount() != null) {
                    request.addParameter("TargetConfiguration." + targetConfigurationsListIndex + ".InstanceCount",
                            StringUtils.fromInteger(targetConfigurationsListValue.getInstanceCount()));
                }
                targetConfigurationsListIndex++;
            }
        }

        return request;
    }

}