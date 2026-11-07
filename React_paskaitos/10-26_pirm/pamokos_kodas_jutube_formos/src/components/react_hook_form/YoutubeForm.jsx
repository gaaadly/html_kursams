import { useForm } from "react-hook-form";
import { zodResolver } from '@hookform/resolvers/zod';
import { schemaYoutube } from "./form_vaildation_schema";
import postData from "../../services/post";

function YoutubeForm() {
    const {
        register,
        handleSubmit,
        reset,
        watch,
        formState: { errors },
        getValues,
        trigger //paleidzia validacija
    } = useForm({
        mode: "onBlur", //mode nurodo, kada reacthook tikrina laukus
        reValidateMode: "onChange", //revalidate ant teksto ivedimo
        defaultValues: {
            username: "",
            email: "",
            channel: "",
            favColor: null,
            hobbies: [],
            password: "",
            confirmPassword: ""
        },

        //resolver yra adapteris, kuris prijungia zod prie react formos
        resolver: zodResolver(schemaYoutube)
    });

    // formos duomenis apdorojanti funkcija, duomenys yra objektas
    const formSubmitHandler = async (formDataObject) => {
        await postData({...formDataObject, likes: 0});
        reset();
    };

    const { username, email } = watch();

    return (
        <>
            <div>
                Youtube Forms
                <form onSubmit={handleSubmit(formSubmitHandler)} noValidate>
                    <div>
                        <label htmlFor="username">Username:</label>
                        <br />
                        <input
                            type="text"
                            id="username"
                            name="username"
                            className="border"
                            {...register("username")}
                        />
                        <div className="text-red-500">{errors.username?.message}</div>
                    </div>

                    <div>
                        <label htmlFor="email">Email:</label>
                        <br />
                        <input
                            type="email"
                            id="email"
                            name="email"
                            className="border"
                            {...register("email")}
                        />
                    </div>

                    <div>
                        <label>
                            Favorite Channel
                            <br />
                            <select name="channel" {...register("channel")}>
                                <option value="">-- Select a channel --</option>
                                <option value="Code with Ania Kubow">Code with Ania Kubow</option>
                                <option value="Kevin Powell">Kevin Powell</option>
                                <option value="Net Ninja">Net Ninja</option>
                            </select>
                        </label>
                    </div>

                    <div>
                        <div>Choose your favorite color:</div>
                        <label>
                            <input
                                type="radio"
                                name="favColor"
                                value="red"
                                {...register("favColor")}
                            />
                            Red
                        </label>
                        <br />
                        <label>
                            <input
                                type="radio"
                                name="favColor"
                                value="green"
                                {...register("favColor")}
                            />
                            Green
                        </label>
                        <br />
                        <label>
                            <input
                                type="radio"
                                name="favColor"
                                value="blue"
                                {...register("favColor")}
                            />
                            Blue
                        </label>
                    </div>

                    <div>
                        <div>Select your hobbies:</div>
                        <label>
                            <input
                                type="checkbox"
                                name="hobbies"
                                value="Reading"
                                {...register("hobbies")}
                            />
                            Reading
                        </label>
                        <br />
                        <label>
                            <input
                                type="checkbox"
                                name="hobbies"
                                value="Traveling"
                                {...register("hobbies")}
                            />
                            Traveling
                        </label>
                        <br />
                        <label>
                            <input
                                type="checkbox"
                                name="hobbies"
                                value="Cooking"
                                {...register("hobbies")}
                            />
                            Cooking
                        </label>
                    </div>
                    <div>
                        <label htmlFor="password">Password:</label>
                        <br />

                        <input
                            // type changes between "password" (hidden) and "text" (visible)
                            className="border text-red-500"
                            id="password"
                            style={{ paddingRight: 28 }}
                            {...register("password", {
                                onChange: () => {
                                    //kai keiciam password reiksme tikrina ir pertikrina confirmPassword
                                    if (getValues("confirmPassword")) trigger("confirmPassword");
                                }
                            })}
                        />

                        <div className="error">{errors.password?.message}</div>
                    </div>

                    <div>
                        <label htmlFor="confirmPassword">Confirm password:</label>
                        <br />

                        <input
                            className="border text-red-500"
                            id="confirmPassword"
                            style={{ paddingRight: 28 }}
                            {...register("confirmPassword")}
                        />

                        <div className="error">{errors.confirmPassword?.message}</div>
                    </div>

                    <input type="submit" value="Submit" className="border" />
                </form>
            </div>
            <div>
                <p>{username}</p>
                <p>{email}</p>
            </div>
        </>
    );
}

export default YoutubeForm;
