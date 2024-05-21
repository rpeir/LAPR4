# Application Protocol #
## 1. Introduction ##
The purpose of this application protocol is to facilitate data exchanges between the Shared Board App and the Shared Board Server network applications.

## 2. Protocol Specification ##
### 2.1. Description ###
* Based on TCP (Transmission Control Protocol), therefore, prior to any actual data exchange, a TCP connection must be established.
* Uses the client-server model, where the client application (Shared Board App) requests the TCP connection and the server application (Shared Board Server) accepts it.
* After the TCP connection is established, the client-server is no longer mandatory, so both the client and the server can send data and the other must be able to receive it and respond to it.
* Every request is mandatory to have a response, following the protocol's message format.
* Once the TCP connection is established, the connection is kept alive and used for all required data exchanges while the client application is running.

### 2.2. SBP Message Format ###
|   Field    | Offset(bytes) | Length(bytes) |                                                                                                       Description                                                                                                        |
|:----------:|:-------------:|:-------------:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|  VERSION   |       0       |       1       |                               SBP message format version. This field is a single byte and should be interpreted as an unsigned integer (0 to 255). The present message format number is 1.                               |
|    CODE    |       1       |       1       |                                                    This field identifies the type of request or response, it should be interpreted as an unsigned integer (0 to 255).                                                    |
| D_LENGHT_1 |       2       |       1       |                                             This filed is used to specify the lenght in bytes of the DATA field. It should be interpreted as an unsigned integer (0 to 255).                                             |
| D_LENGHT_2 |       3       |       1       |                                             This filed is used to specify the lenght in bytes of the DATA field. It should be interpreted as an unsigned integer (0 to 255).                                             |
|    DATA    |       4       |       -       | Contains data to meet the specific needs of the participating applications. The lenght of the DATA field can be calculated as: D_LENGHT_1 * 256 + D_LENGHT_2. The lenght may be zero, indicating that it does not exist. |

### 2.3. SBP Message Codes ###
| Code |                                                                                                                                                   Meaning                                                                                                                                                    |
|:----:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|  0   |                                                                    *COMMETST*-Communications test request with no other effect on the counterpart application that the response with a code two message (ACK). This request has no data.                                                                     |
|  1   |                                           *DISCONN*-End of session request. The counterpart application is supposed to respond with a code two message, afterwards both applications are expected to close the session (TCP Connection). This request has no data.                                           |
|  2   |                                                                                     *ACK*- Generic acknowledgment and success response message. Used in response to successful requests. This response contains no data.                                                                                     |
|  3   | *ERR*- Error response message. Used in response to unsuccessful requests that caused an error. This response message may carry a human readable phrase explaining the error. If used, the phrase explaining is carried in the DATA field as string of ASCII codes, it is not required to be null terminated. |
|  4   |                                                                                                                                     *AUTH*- User authentication request.                                                                                                                                     |

#### Note: In Sprint C, additional unique message codes will be added to the protocol, to meet the specific needs of the new features. Notice that as long as the message format is the same,adding new message codes does not change the message format version.

### 3. User Authentication ###
* Once the TCP connection is established between the Shared Board App (client) and the Shared Board Servers (server), the client is forced to authenticate the local user by sending an AUTH request. After the successful AUTH, the server must ignore any request from the client with a code above 4, and return an ERR message as response.
* The user authentication is achieved by a username and password pair, both will be provided to the client application by the local user running it.
* The username and password values are incorporated in the AUTH request at DATA field as two NULL terminated Strings of ASCII codes, first the username, followed by the password.
* The response to an AUTH request may be an ACK, meaning the authentication was successful, or an ERR, meaning it has failed. In case of failure, addition AUTH requests may be tried by the client.

### Note: In the final of Sprint B, these 5 message codes are expected to be implemented and fully operational in the Shared Board Application (client) and the Shared Board Server Application(server).
